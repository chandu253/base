package com.sri.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.sri.initiator.CustomConfigurableConnectionProviderInitiator;

public class SRITest {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.addInitiator(new CustomConfigurableConnectionProviderInitiator()).build();
		SessionFactory factory = configuration.buildSessionFactory(registry);
		Session session = factory.openSession();
		session.close();
		factory.close();
	}
}





