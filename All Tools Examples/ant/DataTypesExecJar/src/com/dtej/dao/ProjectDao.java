package com.dtej.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dtej.util.ConnectionManager;

public class ProjectDao {
	public void showProjects() throws SQLException {
		ConnectionManager connectionManager = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;

		try {
			connectionManager = ConnectionManager.getInstance();
			connection = connectionManager.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from projects");
			while (rs.next()) {
				System.out.println(rs.getInt("project_no") + " - " + rs.getString("project_nm"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

	}
}
