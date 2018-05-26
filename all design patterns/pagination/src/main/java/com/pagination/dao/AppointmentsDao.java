package com.pagination.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pagination.bo.AppointmentBo;
import com.pagination.execption.PersistenceException;
import com.pagination.util.ConnectionManager;

public class AppointmentsDao {
	private final String SQL_GET_APPOINTMENTS = "select * from appointments order by appointment_dt desc";
	private final String SQL_GET_NO_OF_APPOINTMENTS = "select count(1) from appointments";

	public List<AppointmentBo> getAppointments(final int pageNo, final int pageSize) {
		List<AppointmentBo> appointments = null;
		ConnectionManager cManager = null;
		Connection connection = null;
		AppointmentBo bo = null;
		Statement stmt = null;
		ResultSet rs = null;
		int startIndex = 0;
		int endIndex = 0;
		int record = 1;

		try {
			startIndex = (pageSize * (pageNo - 1)) + 1;
			endIndex = (pageSize * (pageNo - 1)) + pageSize;

			cManager = ConnectionManager.getInstance();
			connection = cManager.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(SQL_GET_APPOINTMENTS);
			appointments = new ArrayList<>();
			while (rs.next() && record <= endIndex) {
				if (record >= startIndex) {
					bo = new AppointmentBo();
					bo.setAppointmentNo(rs.getInt("appointment_no"));
					bo.setAppointmentDate(rs.getDate("appointment_dt"));
					bo.setDoctorName(rs.getString("doctor_nm"));
					bo.setPatientName(rs.getString("patient_nm"));
					appointments.add(bo);
				}
				record++;
			}
		} catch (SQLException e) {
			throw new PersistenceException(e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e) {
				throw new PersistenceException(e);
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				throw new PersistenceException(e);
			}

		}
		return appointments;
	}

	public int getNoOfAppointments() {
		ConnectionManager cManager = null;
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		int records = 0;

		try {
			cManager = ConnectionManager.getInstance();
			connection = cManager.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(SQL_GET_NO_OF_APPOINTMENTS);
			if (rs.next()) {
				records = rs.getInt(1);
			}

		} catch (SQLException e) {
			throw new PersistenceException(e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e) {
				throw new PersistenceException(e);
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				throw new PersistenceException(e);
			}

		}
		return records;
	}
}
