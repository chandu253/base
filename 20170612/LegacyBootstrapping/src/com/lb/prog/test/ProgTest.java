package com.lb.prog.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lb.cfg.util.CFGSessionFactoryRegistry;
import com.lb.entities.Address;
import com.lb.prog.util.ProgSessionFactoryRegistry;

public class ProgTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Address address = null;

		try {
			sessionFactory = ProgSessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			address = (Address) session.get(Address.class, 1011);
			System.out.println(address);
		} finally {
			if (session != null) {
				session.close();
			}
			ProgSessionFactoryRegistry.closeSessionFactory();
		}
	}
}
