package com.msf.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.msf.entities.Vehicle;
import com.msf.helper.SessionFactoryRegistry;

public class VehicleDao {
	public void saveVehicle(Vehicle vehicle) {
		boolean flag = false;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(vehicle);
			flag = true;
		} finally {
			if (session != null) {
				if (flag == true) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
				session.close();
			}
		}
	}
}
