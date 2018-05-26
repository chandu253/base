package com.dmlo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dmlo.entities.Doctor;
import com.dmlo.util.SessionFactoryRegistry;

public class DMLUpdateAndMergeTest {
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
			
			// persistent entity object
			//doctor = (Doctor) session.get(Doctor.class, 1);
			doctor=  new Doctor();
			doctor.setDoctorNo(2);
			session.delete(doctor);
			
			// detached object
			/*Doctor doctor1 = new Doctor();
			doctor1.setDoctorNo(1);
			doctor1.setDoctorName("Ahsok");
			doctor1.setExperience(11);
			doctor1.setQualification("mbbs");
			doctor1.setSpecialization("Heart Surgery");
			session.merge(doctor1);*/
			
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
