package com.mtmm.test;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mtmm.entities.Product;
import com.mtmm.entities.User;
import com.mtmm.util.SessionFactoryRegistry;

public class ManyToManyMapTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		User user = null;
		Product product = null;
		Map<Float, User> bidders = null;
		boolean flag = false;

		try {
			sessionFactory =SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			bidders = new HashMap<Float, User>();
			user = new User();
			user.setFirstName("Joy");
			user.setLastName("J");
			user.setContactNo("94949646");
			user.setEmailAddress("joy@gmail.com");
			session.save(user);
			
			bidders.put(100f, user);
			
			user = new User();
			user.setFirstName("Phil");
			user.setLastName("K");
			user.setContactNo("949493524");
			user.setEmailAddress("phil@gmail.com");
			session.save(user);
			bidders.put(105f, user);
			
			product = new Product();
			product.setDescription("Lenova K3 Power");
			product.setOwnerName("Sharil");
			product.setBasePrice(90);
			product.setBidders(bidders);
			session.save(product);
			
			
			
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






