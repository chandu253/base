package com.otmsan.test;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.otmsan.entities.Appointment;
import com.otmsan.entities.Patient;
import com.otmsan.util.SessionFactoryRegistry;

public class OTOMSetTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		Patient patient = null;
		Appointment appointment = null;
		Set<Appointment> appointments = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			
			patient = new Patient();
			patient.setPatientName("Blake");
			
			appointment = new Appointment();
			appointment.setDoctorName("sriman");
			session.save(appointment);
			appointments = new HashSet<>();
			appointments.add(appointment);
			
			appointment = new Appointment();
			appointment.setDoctorName("ajay");
			session.save(appointment);
			appointments.add(appointment);
			
			patient.setAppointments(appointments);
			session.save(patient);

			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
			SessionFactoryRegistry.closeSessionFactory();
		}

	}
}
