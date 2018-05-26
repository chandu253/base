package com.otml.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.otml.entities.Project;
import com.otml.entities.Resource;
import com.otml.util.SessionFactoryRegistry;

public class OTOMListTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		Project project = null;
		Resource resource = null;
		List<Resource> resources = null;
		boolean flag = false;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			resources = new ArrayList<Resource>();

			resource = new Resource();
			resource.setResourceName("Roy");
			resource.setRole("Lead");
			resource.setStartDate(new Date());
			resource.setEndDate(new Date());
			session.save(resource);

			resources.add(resource);

			resource = new Resource();
			resource.setResourceName("Brain");
			resource.setRole("Manager");
			resource.setStartDate(new Date());
			resource.setEndDate(new Date());
			session.save(resource);
			resources.add(resource);

			project = new Project();
			project.setTitle("EMS");
			project.setDescription("Election Management System");
			project.setDuration(36);
			project.setResources(resources);
			session.save(project);

			/*
			 * project = (Project) session.get(Project.class, 3);
			 * System.out.println(project);
			 */

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
