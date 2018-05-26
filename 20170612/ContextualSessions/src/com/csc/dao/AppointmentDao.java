package com.csc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.csc.entities.Appointment;
import com.csc.util.SessionFactoryRegistry;

public class AppointmentDao {
	public int saveAppointment(Appointment appointment) {
		SessionFactory sessionFactory = null;
		Session session = null;
		int appointmentNo = 0;

		sessionFactory = SessionFactoryRegistry.getSessionFactory();
		session = sessionFactory.getCurrentSession();

		appointmentNo = (Integer) session.save(appointment);

		return appointmentNo;

	}
}
