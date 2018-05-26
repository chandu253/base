package com.ha.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ha.entities.Sparepart;
import com.ha.util.SessionFactoryRegistry;

public class HATest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Sparepart sparepart = new Sparepart();
			sparepart.setSparepartNo(36);
			sparepart.setSparepartName("Gear Box");
			sparepart.setModelNo("M9383");
			sparepart.setPurchaseDate(new Date());
			sparepart.setPrice(35353);

			session.save(sparepart);

			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
			if (session != null) {
				session.close();
			}
			SessionFactoryRegistry.closeSessionFactory();
		}
	}
}
