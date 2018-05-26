package com.hql.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hql.entities.Project;
import com.hql.util.SessionFactoryRegistry;

public class ProjectHQLTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		List<Project> projects = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			Query allProjectsQuery = session.createQuery("from Project");
			projects = allProjectsQuery.list();
			for (Project p : projects) {
				System.out.println(p);
			}
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
