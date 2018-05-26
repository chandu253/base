package com.lb.prog.util;

import java.io.File;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Configuration;

/**
 * When we want to customize bootstrapping
 */
public class ProgSessionFactoryRegistry {
	private static SessionFactory sessionFactory;

	static {
		try {
			Properties props = new Properties();
			props.load(ProgSessionFactoryRegistry.class.getClassLoader()
					.getResourceAsStream("db.properties"));

			Configuration configuration = new Configuration();
			configuration.setProperty("hibernate.connection.driver_class",
					props.getProperty("db.driverClassname"));
			configuration.setProperty("hibernate.connection.url",
					props.getProperty("db.url"));
			configuration.setProperty("hibernate.connection.username",
					props.getProperty("db.username"));
			configuration.setProperty("hibernate.connection.password",
					props.getProperty("db.password"));

			configuration.setProperty("hibernate.show_sql", "true");
			configuration.addResource("com/lb/entities/Address.hbm.xml");
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
