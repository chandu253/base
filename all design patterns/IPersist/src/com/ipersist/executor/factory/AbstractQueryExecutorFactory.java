package com.ipersist.executor.factory;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ipersist.config.Config;
import com.ipersist.exception.IPersistConfigException;
import com.ipersist.exception.IPersistSqlException;
import com.ipersist.executor.QueryExecutor;

abstract public class AbstractQueryExecutorFactory {
	// factory method
	public QueryExecutor newQueryExecutor(String type, String configFile) {
		QueryExecutor queryExecutor = null;
		Config config = null;
		Connection connection = null;

		queryExecutor = createQueryExecutor(type);
		// standard instantiation process applied for all the classes of the component
		// family
		config = readConfig(configFile);
		connection = createConnection(config);
		queryExecutor.setConfig(config);
		queryExecutor.setConnection(connection);
		queryExecutor.setSql(config.getSql());

		return queryExecutor;
	}

	private Config readConfig(String configFile) {
		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;
		Document doc = null;
		Node queryExecutor = null;
		NodeList childs = null;
		Config config = null;

		try {
			factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringElementContentWhitespace(true);
			builder = factory.newDocumentBuilder();
			doc = builder.parse(this.getClass().getClassLoader().getResourceAsStream(configFile));
			config = new Config();
			queryExecutor = doc.getFirstChild();
			childs = queryExecutor.getChildNodes();
			for (int i = 0; i < childs.getLength(); i++) {
				String nName = childs.item(i).getNodeName();
				if (nName.equals("config")) {
					NodeList configNodes = childs.item(i).getChildNodes();
					for (int j = 0; j < configNodes.getLength(); j++) {
						String cnName = configNodes.item(j).getNodeName();
						String cValue = configNodes.item(j).getFirstChild().getTextContent();

						if (cnName.equals("driverClassname")) {
							config.setDriverClassname(cValue);
						} else if (cnName.equals("url")) {
							config.setUrl(cValue);
						} else if (cnName.equals("username")) {
							config.setUsername(cValue);
						} else if (cnName.equals("password")) {
							config.setPassword(cValue);
						}
					}
				} else if (nName.equals("sql")) {
					config.setSql(childs.item(i).getFirstChild().getTextContent());
				}
			}

		} catch (Exception e) {
			throw new IPersistConfigException("unable to config file :" + configFile, e);
		}

		return config;
	}

	private Connection createConnection(Config config) {
		Connection con = null;

		try {
			Class.forName(config.getDriverClassname());
			con = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
			con.setAutoCommit(false);
		} catch (Exception e) {
			throw new IPersistSqlException("unable to create connection", e);
		}
		return con;
	}

	protected abstract QueryExecutor createQueryExecutor(String type);

}
