package com.dtej.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	private static ConnectionManager instance;
	protected String driverClassname;
	protected String url;
	protected String username;
	protected String password;

	private ConnectionManager() {
		try {
			Properties props = new Properties();
			props.load(this.getClass().getClassLoader().getResourceAsStream("db.properties"));
			driverClassname = props.getProperty("driverClassname");
			url = props.getProperty("url");
			username = props.getProperty("username");
			password = props.getProperty("password");
			Class.forName(driverClassname);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ConnectionManager getInstance() {
		if (instance == null) {
			synchronized (ConnectionManager.class) {
				if (instance == null) {
					instance = new ConnectionManager();
				}
			}
		}
		return instance;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}
