package com.dmlo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dmlo.entities.Doctor;
import com.dmlo.util.SessionFactoryRegistry;

public class DMLSaveTest {

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

			Object doctorNo = session.save(doctor);
			System.out.println("saved...");
			System.out.println("doctorNo : " + doctorNo);
			session.evict(doctor);
			session.save(doctor);

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
