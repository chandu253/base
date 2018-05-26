package com.fh.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fh.entities.Mechanic;

public class FHTest {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Mechanic mechanic = (Mechanic) session.get(Mechanic.class, 5011);
		System.out.println(mechanic);
	}
}






