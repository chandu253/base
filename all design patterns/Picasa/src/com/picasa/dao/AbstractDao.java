package com.picasa.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

abstract public class AbstractDao {
	protected void closeResources(ResultSet rs, Statement statement, Connection connection) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
		}
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
		}
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
		}
	}
}
