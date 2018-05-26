package com.ci.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ci.entities.ResourceAssignment;
import com.ci.entities.ResourceAssignmentPK;
import com.ci.util.SessionFactoryRegistry;

public class CITest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		ResourceAssignment resourceAssignment = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			/*
			 * resourceAssignment = new ResourceAssignment();
			 * resourceAssignment.setResourceNo(1024); resourceAssignment.setProjectNo(101);
			 * resourceAssignment.setAssignmentStartDate(new Date());
			 * resourceAssignment.setRole("Lead");
			 * resourceAssignment.setAllocationPercentage(100);
			 * 
			 * session.save(resourceAssignment);
			 */

			ResourceAssignmentPK id = new ResourceAssignmentPK();
			id.setResourceNo(1024);
			id.setProjectNo(101);

			resourceAssignment = (ResourceAssignment) session.get(ResourceAssignment.class, id);
			System.out.println(resourceAssignment);
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
