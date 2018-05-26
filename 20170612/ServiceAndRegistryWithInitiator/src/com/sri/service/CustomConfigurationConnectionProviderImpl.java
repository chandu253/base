package com.sri.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import org.hibernate.cfg.Environment;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.service.spi.Configurable;
import org.hibernate.service.spi.Startable;
import org.hibernate.service.spi.Stoppable;

public class CustomConfigurationConnectionProviderImpl
		implements ConnectionProvider, Startable, Stoppable, Configurable {
	protected String driverClass;
	protected String url;
	protected String username;
	protected String password;

	@Override
	public boolean isUnwrappableAs(Class arg0) {
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) {
		return null;
	}

	@Override
	public void configure(Map properties) {
		System.out.println("configure()");
		driverClass = (String) properties.get(Environment.DRIVER);
		url = (String) properties.get(Environment.URL);
		username = (String) properties.get(Environment.USER);
		password = (String) properties.get(Environment.PASS);
	}

	@Override
	public void stop() {

	}

	@Override
	public void start() {

	}

	@Override
	public void closeConnection(Connection conn) throws SQLException {
		if (conn.isClosed() == false) {
			System.out.println("closeConnection()");
			conn.close();
		}
	}

	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			System.out.println("getConnection()");
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);
		} catch (Exception e) {
			new SQLException(e);
		}
		return conn;
	}

	@Override
	public boolean supportsAggressiveRelease() {
		// TODO Auto-generated method stub
		return false;
	}

}
