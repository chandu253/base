package com.mdsb.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

public class CustomConnectionProviderImpl implements ConnectionProvider {

	@Override
	public boolean isUnwrappableAs(Class arg0) {
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) {
		return null;
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
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/automobiles", "root", "root");
			conn.setAutoCommit(false);
			System.out.println("getConnection()");
		} catch (Exception e) {
			throw new SQLException(e);
		}
		return conn;
	}

	@Override
	public boolean supportsAggressiveRelease() {
		return true;
	}

}
