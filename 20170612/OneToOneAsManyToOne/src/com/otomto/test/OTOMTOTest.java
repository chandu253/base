package com.otomto.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.otomto.entities.Account;
import com.otomto.entities.Organization;
import com.otomto.util.SessionFactoryRegistry;

public class OTOMTOTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		Account account = null;
		Organization organization = null;
		boolean flag = false;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			
			/*organization = new Organization();
			organization.setOrganizationName("Stackspace");
			organization.setEstablishedDate(new Date());
			organization.setDescription("Software solutions");
			organization.setBusinessType("IT Services");
			session.save(organization);
			
			account = new Account();
			account.setContactPerson("Susan");
			account.setOpenedDate(new Date());
			account.setContactNo("898905535");
			account.setEmailAddress("susan@gmail.com");
			account.setOrganization(organization);
			session.save(account);
	*/		

			account = (Account) session.get(Account.class, 1);
			System.out.println(account.getOrganization().getOrganizationName());
			
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
