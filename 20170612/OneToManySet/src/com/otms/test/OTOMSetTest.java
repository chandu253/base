package com.otms.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.otms.entities.Project;
import com.otms.entities.Resource;
import com.otms.util.SessionFactoryRegistry;

public class OTOMSetTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		Project project = null;
		Resource resource = null;
		Set<Resource> resources = null;
		boolean flag = false;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			resources = new HashSet<Resource>();
			
			/*project = new Project();
			project.setTitle("EMS");
			project.setDescription("Election Management System");
			project.setDuration(36);
			
			resource = new Resource();
			resource.setResourceName("Roy");
			resource.setRole("Lead");
			resource.setStartDate(new Date());
			resource.setEndDate(new Date());
			resource.setProject(project);
			
			resources.add(resource);
			
			resource = new Resource();
			resource.setResourceName("Brain");
			resource.setRole("Manager");
			resource.setStartDate(new Date());
			resource.setEndDate(new Date());
			resource.setProject(project);
			resources.add(resource);				
			
			project.setResources(resources);
			session.save(project);*/
			
			/*project = (Project) session.get(Project.class, 1);
			resource = new Resource();
			resource.setResourceName("Greg");
			resource.setRole("Sr Manager");
			resource.setStartDate(new Date());
			resource.setEndDate(new Date());
			project.getResources().add(resource);
			session.update(project);*/
			
			project = (Project) session.get(Project.class, 1);
			Iterator<Resource> it = project.getResources().iterator();
			resource = it.next();
			it.remove();
			session.update(project);
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
