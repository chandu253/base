package com.hjpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hjpa.entities.Address;

public class JpaTest {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		Address address = null;
		boolean flag = false;

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("automobiles");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			
			address = new Address();
			
			address.setAddressId(324);
			address.setAddressLine1("hi-tech city");
			address.setAddressLine2("Madhapur");
			address.setCity("Hyderabad");
			address.setState("TS");
			address.setZip(500081);
			address.setCountry("India");
			
			entityManager.persist(address);
			
			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
			if (entityManager != null) {
				entityManager.close();
			}
			if (entityManagerFactory != null) {
				entityManagerFactory.close();
			}
		}

	}
}
