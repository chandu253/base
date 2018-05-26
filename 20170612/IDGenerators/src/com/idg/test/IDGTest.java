package com.idg.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.idg.entities.Appointment;
import com.idg.util.SessionFactoryRegistry;

public class IDGTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			for (int i = 0; i < 1; i++) {
				Appointment appointment = new Appointment();
				appointment.setAppointmentDate(new Date());
				appointment.setDoctor("Sudhakar");
				appointment.setPatient("John");
				appointment.setMobileNumber("938494956");
				appointment.setEmailAddress("john@gmail.com");
				session.save(appointment);
				System.out.println("appointmentNo : " + appointment.getAppointmentNo());
			}
			// transaction.commit();
			// session.close();

			// session = sessionFactory.openSession();
			// transaction = session.beginTransaction();
			/*
			 * Appointment appointment1 = new Appointment();
			 * appointment1.setAppointmentDate(new Date()); appointment1.setDoctor("Ramu");
			 * appointment1.setPatient("Ravi"); appointment1.setMobileNumber("938494955");
			 * appointment1.setEmailAddress("ravi@gmail.com"); session.save(appointment1);
			 */

			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
				session.close();
			}
			SessionFactoryRegistry.closeSessionFactory();
		}

	}
}
