package com.pagination.delegate;

import java.util.List;

import com.pagination.bo.AppointmentBo;
import com.pagination.dao.AppointmentsDao;

public class AppointmentDelegate {
	private AppointmentsDao appointmentDao;

	public AppointmentDelegate() {
		appointmentDao = new AppointmentsDao();
	}

	public List<AppointmentBo> getAppointments(int pageNo, int pageSize) {
		return appointmentDao.getAppointments(pageNo, pageSize);
	}

	public int getNoOfAppointments() {
		return appointmentDao.getNoOfAppointments();
	}

}
