package com.ipersist.executor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ipersist.config.Config;
import com.ipersist.exception.IPersistSqlException;

abstract public class QueryExecutor {
	protected String sql;
	protected Config config;
	protected Connection connection;

	public Object execute() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			return handle(rs);
		} catch (SQLException e) {
			throw new IPersistSqlException("unable to execute query", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				throw new IPersistSqlException("unable to close resultset", e);
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				throw new IPersistSqlException("unable to close statement", e);
			}
		}
	}

	protected abstract Object handle(ResultSet rs) throws SQLException;

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
