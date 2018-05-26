package com.mdsb.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

import com.mdsb.service.CustomConnectionProviderImpl;

public class MDTest {
	public static void main(String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.addService(ConnectionProvider.class, new CustomConnectionProviderImpl()).configure().build();

		MetadataSources metadataSources = new MetadataSources(registry);
		Metadata metadata = metadataSources.buildMetadata();
		SessionFactory sessionFactory = metadata.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.close();
		sessionFactory.close();
	}
}
