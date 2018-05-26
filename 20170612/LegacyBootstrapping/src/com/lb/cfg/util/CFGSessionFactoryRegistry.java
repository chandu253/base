package com.lb.cfg.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CFGSessionFactoryRegistry {
	private static SessionFactory sessionFactory;

	static {
		try {
			Configuration configuration = new Configuration()
					.configure("com/lb/common/automobiles.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}

}
