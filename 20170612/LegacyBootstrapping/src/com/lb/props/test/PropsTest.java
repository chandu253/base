package com.lb.props.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lb.entities.Address;
import com.lb.props.util.PropsSessionFactoryRegistry;

public class PropsTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Address address = null;

		try {
			sessionFactory = PropsSessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			address = (Address) session.get(Address.class, 1011);
			System.out.println(address);
		} finally {
			if (session != null) {
				session.close();
			}
			PropsSessionFactoryRegistry.closeSessionFactory();
		}
	}
}
