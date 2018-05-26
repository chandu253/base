package com.picasa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.picasa.util.ConnectionManager;

public class GalleryDao extends AbstractDao {
	private final String SQL_GET_FIRST_IMG = "select min(image_id) from gallery";
	private final String SQL_GET_NEXT_IMG = "select min(image_id) from gallery where image_id > ?";
	private final String SQL_GET_PREV_IMG = "select max(image_id) from gallery where image_id < ?";
	private final String SQL_GET_IMG = "select image_content from gallery where image_id = ?";

	public Integer getFirstImage() {
		ConnectionManager connectionManager = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		Integer imageId = null;

		try {
			connectionManager = ConnectionManager.getInstance();
			connection = connectionManager.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(SQL_GET_FIRST_IMG);
			if (rs.next()) {
				imageId = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(rs, statement, connection);
		}
		return imageId;
	}

	public Integer getNextImage(Integer cImageId) {
		ConnectionManager connectionManager = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Integer imageId = null;

		try {
			connectionManager = ConnectionManager.getInstance();
			connection = connectionManager.getConnection();
			pstmt = connection.prepareStatement(SQL_GET_NEXT_IMG);
			pstmt.setInt(1, cImageId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				imageId = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(rs, pstmt, connection);
		}
		return imageId;
	}

	public Integer getPrevImage(Integer cImageId) {
		ConnectionManager connectionManager = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Integer imageId = null;

		try {
			connectionManager = ConnectionManager.getInstance();
			connection = connectionManager.getConnection();
			pstmt = connection.prepareStatement(SQL_GET_PREV_IMG);
			pstmt.setInt(1, cImageId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				imageId = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(rs, pstmt, connection);
		}
		return imageId;
	}

	public byte[] getImage(Integer imageId) {
		ConnectionManager connectionManager = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		byte[] image = null;

		try {
			connectionManager = ConnectionManager.getInstance();
			connection = connectionManager.getConnection();
			pstmt = connection.prepareStatement(SQL_GET_IMG);
			pstmt.setInt(1, imageId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				image = rs.getBytes(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(rs, pstmt, connection);
		}
		return image;
	}
}
