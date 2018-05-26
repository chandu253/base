package com.mtms.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mtms.entities.Job;
import com.mtms.entities.Member;
import com.mtms.util.SessionFactoryRegistry;

public class ManyToManySetTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		Job job = null;
		Member member = null;
		boolean flag = false;
		Set<Member> applicants = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			applicants = new HashSet<Member>();
			
			member = new Member();
			member.setFirstName("Roy");
			member.setLastName("L");
			member.setQualification("Btech");
			member.setExperience(1);
			session.save(member);
			applicants.add(member);
			
			member = new Member();
			member.setFirstName("David");
			member.setLastName("H");
			member.setExperience(2);
			member.setQualification("btech");
			session.save(member);
			applicants.add(member);
			
			job = new Job();
			job.setDescription("Senior software engineer");
			job.setPositions(2);
			job.setTitle("Java Developer");
			session.save(job);
			
			job = (Job) session.get(Job.class, 1);
			member = (Member) session.load(Member.class, 1);
			
			applicants = job.getApplicants();
			if(applicants == null) {
				applicants = new HashSet();
			}
			applicants.add(member);
			job.setApplicants(applicants);
			session.update(job);

			

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
