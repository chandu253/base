package com.tpch.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tpch.entities.CheckPayment;
import com.tpch.entities.Payment;
import com.tpch.util.SessionFactoryRegistry;

public class TPCHTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		Payment payment = null;
		CheckPayment checkPayment = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();

			payment = new Payment();
			payment.setPaymentDate(new Date());
			payment.setDescription("Television");
			payment.setAmount(35334);
			session.save(payment);

			checkPayment = new CheckPayment();
			checkPayment.setPaymentDate(new Date());
			checkPayment.setDescription("Refrigerator");
			checkPayment.setAmount(45345);
			checkPayment.setCheckNo(35353);
			checkPayment.setIssuedBank("Icici Bank");
			checkPayment.setCheckDate(new Date());
			checkPayment.setIssuerAccountNo("ac939535");

			session.save(checkPayment);
			
			/*payment = (Payment) session.get(Payment.class, 2);
			System.out.println("class : " + payment.getClass().getName());*/

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







