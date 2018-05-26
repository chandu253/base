package com.slc.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.slc.entities.Advisor;
import com.slc.util.SessionFactoryRegistry;

public class SLCTest {
	public static void main(String[] args) {
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			factory = SessionFactoryRegistry.getSessionFactory();
			session = factory.getCurrentSession();
			transaction = session.beginTransaction();

			Advisor advisor = (Advisor) session.get(Advisor.class, 1);
			System.out.println(advisor);

			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
		}

		try {
			session = factory.getCurrentSession();
			transaction = session.beginTransaction();

			Advisor advisor = (Advisor) session.get(Advisor.class, 1);
			System.out.println(advisor);

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
