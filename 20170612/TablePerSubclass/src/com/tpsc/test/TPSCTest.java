package com.tpsc.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tpsc.entities.CardPayment;
import com.tpsc.entities.CheckPayment;
import com.tpsc.entities.Payment;
import com.tpsc.util.SessionFactoryRegistry;

public class TPSCTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		Payment payment = null;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			payment = new Payment();
			payment.setPaidDate(new Date());
			payment.setDescription("Television");
			payment.setAmount(35353);
			int paymentNo = (Integer) session.save(payment);
			System.out.println("paymentNo : " + paymentNo);
			
			CheckPayment cPayment= new CheckPayment();
			cPayment.setPaidDate(new Date());
			cPayment.setDescription("Refrigerator");
			cPayment.setAmount(35353);
			cPayment.setCheckNo(3535);
			cPayment.setCheckDate(new Date());
			cPayment.setIssuedBank("Icici Bank");
			paymentNo = (Integer) session.save(cPayment);
			System.out.println("paymentNo : " + paymentNo);
			
			CardPayment cardPayment = new CardPayment();
			cardPayment.setPaidDate(new Date());
			cardPayment.setDescription("Mobile");
			cardPayment.setAmount(4456);
			cardPayment.setCardNo(3535353);
			cardPayment.setCardHolderName("Raghu");
			cardPayment.setCardType("visa");
			
			paymentNo = (Integer) session.save(cardPayment);
			System.out.println("paymentNo : " + paymentNo);

			/*CheckPayment checkPayment = (CheckPayment) session.get(CheckPayment.class, 1);
			System.out.println(checkPayment);*/
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










