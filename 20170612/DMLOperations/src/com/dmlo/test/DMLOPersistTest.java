package com.dmlo.test;

import org.hibernate.Session;

import org.hibernate.Transaction;

import com.dmlo.entities.Doctor;
import com.dmlo.util.SessionFactoryRegistry;

import org.hibernate.SessionFactory;

public class DMLOPersistTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		Doctor doctor = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			doctor = new Doctor();
			doctor.setDoctorName("Rahul");
			doctor.setExperience(24);
			doctor.setQualification("mbbs");
			doctor.setSpecialization("nueralagist");

			session.persist(doctor);
			System.out.println("persisted...");
			System.out.println("doctorNo : " + doctor.getDoctorNo());
			session.evict(doctor);
			session.persist(doctor);

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
