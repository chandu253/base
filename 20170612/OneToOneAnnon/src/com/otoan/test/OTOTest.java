package com.otoan.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.otoan.entities.Account;
import com.otoan.entities.Subscription;
import com.otoan.util.SessionFactoryRegistry;

public class OTOTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		Account account = null;
		Subscription subscription = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			account = new Account();
			account.setAccountHolderName("David");
			session.save(account);
			
			subscription = new Subscription();
			subscription.setSubscriptionType("postpaid");
			subscription.setPlanName("unlimited");
			subscription.setAccount(account);
			session.save(subscription);

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
