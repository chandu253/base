package com.mt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mt.entities.Advisor;

public class MTTest {
	public static void main(String[] args) {
		boolean flag = false;
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			Advisor advisor = new Advisor();
			advisor.setAdvisorNo(24);
			advisor.setFirstName("Adrew");
			advisor.setLastName("X");
			advisor.setQualification("MTech");
			advisor.setExperience(4);
			advisor.setContactNo("9193839");
			advisor.setEmailAddress("adrew@gmail.com");

			session.save(advisor);
			flag = true;
		} finally {
			if (session != null && transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
				session.close();
			}
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		}

	}
}
