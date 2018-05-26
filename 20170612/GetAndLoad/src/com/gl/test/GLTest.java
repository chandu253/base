package com.gl.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.al.util.SessionFactoryRegistry;
import com.gl.entities.Account;
import com.gl.entities.IAccount;

public class GLTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			
			IAccount account =(IAccount) session.load(Account.class, "ac35");
			System.out.println("executed load method");
			System.out.println("Class : " + account.getClass().getName());
			System.out.println("account Holder Name : " + account.getAccountHolderName());
			System.out.println("balance : " + account.getBalance());
			
		} finally {
			if (session != null) {
				//session.close();
			}
			SessionFactoryRegistry.closeSessionFactory();
		}
	}
}





