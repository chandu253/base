package com.tpcc.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tpcc.entities.CardPayment;
import com.tpcc.entities.CheckPayment;
import com.tpcc.entities.Payment;
import com.tpcc.util.SessionFactoryRegistry;

public class TPCCTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();

			Payment payment = new Payment();
			payment.setDescription("Television");
			payment.setPaidDate(new Date());
			payment.setAmount(33535);
			int paymentNo = (Integer) session.save(payment);
			System.out.println("paymentNo : " + paymentNo);
			
			CheckPayment cPayment = new CheckPayment();
			cPayment.setDescription("Fridge");
			cPayment.setPaidDate(new Date());
			cPayment.setAmount(3535);
			cPayment.setCheckNo(353);
			cPayment.setCheckDate(new Date());
			cPayment.setIssuedBank("Icicibank");
			paymentNo = (Integer) session.save(cPayment);
			System.out.println("paymentNo : " + paymentNo);
			
			CardPayment cardPayment = new CardPayment();
			cardPayment.setDescription("Mobile");
			cardPayment.setPaidDate(new Date());
			cardPayment.setAmount(353);
			cardPayment.setCardNo(44);
			cardPayment.setCardHolderName("Mathew");
			cardPayment.setCardType("Visa");
			paymentNo = (Integer) session.save(cardPayment);
			System.out.println("paymentNo : " + paymentNo);

			/*CheckPayment cp = (CheckPayment) session.get(CheckPayment.class, 1);
			System.out.println(cp);*/
			
			payment = (Payment) session.get(Payment.class, 2);
			System.out.println(payment);
			
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
