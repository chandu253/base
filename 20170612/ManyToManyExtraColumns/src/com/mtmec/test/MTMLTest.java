package com.mtmec.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mtmec.entities.Blog;
import com.mtmec.entities.BlogUserRatingPK;
import com.mtmec.entities.BlogUserRatings;
import com.mtmec.entities.SystemUser;
import com.mtmec.util.SessionFactoryRegistry;

public class MTMLTest {
	public static void main(String[] args) {

		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		Blog blog = null;
		SystemUser systemUser = null;
		BlogUserRatings blogUserRatings = null;
		BlogUserRatingPK pk = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			
			systemUser = new SystemUser();
			systemUser.setDisplayName("John");
			
			blog = new Blog();
			blog.setTitle("Memory Management");
			blog.setBlogContent("Memory Management in JVM");
			blog.setBlogOwner(systemUser);
			session.save(blog);
			
			SystemUser user = new SystemUser();
			user.setDisplayName("Susan");
			session.save(user);
			
			pk = new BlogUserRatingPK();
			pk.setBlog(blog);
			pk.setSystemUser(user);
			blogUserRatings = new BlogUserRatings();
			blogUserRatings.setBlogUserRatingPK(pk);
			blogUserRatings.setRating(5);
			blogUserRatings.setComments("Nice blog");
			session.save(blogUserRatings);
			

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
