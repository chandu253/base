package com.otomtoan.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.otomtoan.entities.DigitalCard;
import com.otomtoan.entities.SetTopBox;
import com.otomtoan.util.SessionFactoryRegistry;

public class OTOMTOANTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		SetTopBox setTopBox = null;
		DigitalCard digitalCard = null;
		boolean flag = false;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session =sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			
			digitalCard = new  DigitalCard();
			digitalCard.setType("Micro chip");
			session.save(digitalCard);
			
			setTopBox = new SetTopBox();
			setTopBox.setManufacturer("Hathway");
			setTopBox.setPrice(1000f);
			setTopBox.setDigitalCard(digitalCard);
			session.save(setTopBox);
			
			
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
