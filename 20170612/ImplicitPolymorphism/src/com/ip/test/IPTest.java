package com.ip.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ip.entities.Payment;
import com.ip.util.SessionFactoryRegistry;

public class IPTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();

			/*Payment payment = new Payment();
			payment.setDescription("Television");
			payment.setPaidDate(new Date());
			payment.setAmount(33535);
			int paymentNo = (Integer) session.save(payment);
			System.out.println("paymentNo : " + paymentNo);*/
			
			/*CheckPayment cPayment = new CheckPayment();
			cPayment.setDescription("Fridge");
			cPayment.setPaidDate(new Date());
			cPayment.setAmount(3535);
			cPayment.setCheckNo(353);
			cPayment.setCheckDate(new Date());
			cPayment.setIssuedBank("Icicibank");
			int paymentNo = (Integer) session.save(cPayment);
			System.out.println("paymentNo : " + paymentNo);*/
			
			/*CardPayment cPayment = new CardPayment();
			cPayment.setDescription("Mobile");
			cPayment.setPaidDate(new Date());
			cPayment.setAmount(353);
			cPayment.setCardNo(44);
			cPayment.setCardHolderName("Mathew");
			cPayment.setCardType("Visa");
			int paymentNo = (Integer) session.save(cPayment);
			System.out.println("paymentNo : " + paymentNo);*/

			/*CheckPayment cp = (CheckPayment) session.get(CheckPayment.class, 1);
			System.out.println(cp);*/
			
			Payment payment = (Payment) session.get(Payment.class, 1);
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
