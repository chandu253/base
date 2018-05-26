package com.flc.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flc.entities.Product;
import com.flc.util.SessionFactoryRegistry;

import sun.awt.windows.WPrinterJob;

public class FLCTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			/*
			 * Product product = (Product) session.load(Product.class, 1);
			 * System.out.println("load is over");
			 * System.out.println("product name : " + product.getProductName());
			 * 
			 * Product product1 = (Product) session.load(Product.class, 1);
			 * System.out.println("product name : " +
			 * product1.getProductName());
			 * 
			 * System.out.println("product == product1 ? : " + (product ==
			 * product1));
			 */

			/*
			 * Query query1 = session.createQuery("from Product"); List<Product>
			 * products1 = query1.list();
			 * 
			 * Query query2 = session.createQuery("from Product"); List<Product>
			 * products2 = query2.list();
			 * 
			 * for (int i = 0; i < products1.size(); i++) {
			 * System.out.println("product1 == product2 ? : " +
			 * (products1.get(i) == products2.get(i))); }
			 */

			/*
			 * Product product = (Product) session.get(Product.class, 1);
			 * //session.evict(product); //session.clear(); Session session1 =
			 * sessionFactory.openSession(); Product product1 = (Product)
			 * session1.get(Product.class, 1);
			 */

			/*Product product = (Product) session.get(Product.class, 1);
			product.setProductName("QLED 64 inch TV with home theatore");
			session.update(product);

			product.setDescription("QLED Samsung TV");
			session.update(product);

			session.flush();
			Product product1 = (Product) session.get(Product.class, 1);
			System.out.println(product1.getProductName());*/

			Product product =new Product();
			product.setProductId(1);
			product.setProductName("QLED 64 inch TV with home theatore");
			session.update(product);
			
			/*
			 * Product product = new Product(); product.setProductId(2);
			 * product.setProductName("Samsung s8 plus");
			 * product.setDescription("Samsung Galaxy S8");
			 * product.setPrice(64000);
			 * 
			 * session.save(product);
			 * 
			 * product.setDescription("Samsung Galaxy s8 Plus");
			 * session.update(product);
			 */

			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
				session.close();
			}
			SessionFactoryRegistry.closeSessionFactory();
		}

	}
}
