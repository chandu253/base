package com.dmlo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dmlo.entities.Doctor;
import com.dmlo.util.SessionFactoryRegistry;

public class DMLOSUTest {
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
			//doctor.setDoctorNo(-1);
			doctor.setDoctorName("Rahul");
			doctor.setExperience(24);
			doctor.setQualification("mbbs");
			doctor.setSpecialization("nueralagist");

			session.saveOrUpdate(doctor);

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
