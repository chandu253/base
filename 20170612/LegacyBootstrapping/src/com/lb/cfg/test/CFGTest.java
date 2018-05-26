package com.lb.cfg.test;

import com.lb.cfg.util.CFGSessionFactoryRegistry;
import com.lb.entities.Address;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CFGTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Address address = null;

		try {
			sessionFactory = CFGSessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			address = (Address) session.get(Address.class, 1011);
			System.out.println(address);
		} finally {
			if (session != null) {
				session.close();
			}
			CFGSessionFactoryRegistry.closeSessionFactory();
		}
	}
}
