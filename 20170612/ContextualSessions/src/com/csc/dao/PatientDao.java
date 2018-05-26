package com.csc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.csc.entities.Patient;
import com.csc.util.SessionFactoryRegistry;

public class PatientDao {
	public int savePatient(Patient patient) {
		SessionFactory sessionFactory = null;
		Session session = null;
		int patientNo = 0;

		sessionFactory = SessionFactoryRegistry.getSessionFactory();
		session = sessionFactory.getCurrentSession();

		patientNo = (Integer) session.save(patient);

		return patientNo;
	}
}
