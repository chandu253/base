package com.jg.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jg.entities.Project;
import com.jg.util.SessionFactoryRegistry;

public class JGTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		Project project = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			project = new Project();
			project.setTitle("Healthcare Services");
			project.setDescription("Health Management System");
			project.setDomain("healthcare");
			project.setDuration(6);

			session.save(project);
			System.out.println("projectNo  : " + project.getProjectNo());

			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
				session.close();
			}
			SessionFactoryRegistry.closeSessionFactory();
		}
	}
}
