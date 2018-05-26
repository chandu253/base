package com.oto.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.oto.entities.Candidate;
import com.oto.entities.Report;
import com.oto.util.SessionFactoryRegistry;

public class OTOTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		Candidate candidate = null;
		Report report = null;
		boolean flag = false;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session =sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			
			/*candidate = new Candidate();
			candidate.setAppearedDate(new Date());
			candidate.setAppliedFor("Java Technology");
			candidate.setCandidateName("David");
			candidate.setContactNo("93849565");
			candidate.setEmailAddress("david@gmail.com");
			session.save(candidate);
			
			report = new Report();
			report.setReportDate(new Date());
			report.setRating(5);
			report.setComments("Good");
			report.setInterviewerName("Paul");
			report.setCandidate(candidate);
			session.save(report);*/
			report = (Report) session.get(Report.class, 1);
			System.out.println(report);
			

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
