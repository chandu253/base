package com.pagination.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.pagination.execption.PersistenceException;

public class ConnectionManager {
	private static ConnectionManager instance;
	private String driverClassname;
	private String url;
	private String username;
	private String password;

	private ConnectionManager() {
		Properties properties = new Properties();
		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream("db.properties"));
			driverClassname = properties.getProperty("driverClassname");
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
			Class.forName(driverClassname);
		} catch (Exception e) {
			throw new PersistenceException("unable to db.properties", e);
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

	public Connection getConnection() {
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new PersistenceException("unable to open connection", e);
		}
	}
}
