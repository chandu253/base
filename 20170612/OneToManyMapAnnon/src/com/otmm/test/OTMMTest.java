package com.otmm.test;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.otmm.entities.Branch;
import com.otmm.entities.Package;
import com.otmm.util.SessionFactoryRegistry;

public class OTMMTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		Branch branch = null;
		Package cpackage = null;
		Map<String, Package> branchPackages = null;
		boolean flag = false;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			branchPackages = new HashMap<String, Package>();

			cpackage = new Package();
			cpackage.setDescription("heavy machinery");
			cpackage.setSource("hyderabad");
			cpackage.setDestination("banglore");
			cpackage.setWeight(34455);
			session.save(cpackage);
			branchPackages.put("smg001", cpackage);
			cpackage = new Package();
			cpackage.setDescription("office equipment");
			cpackage.setSource("hyderabad");
			cpackage.setDestination("chennai");
			cpackage.setWeight(3445);
			session.save(cpackage);
			branchPackages.put("smg002", cpackage);

			//branch = (Branch) session.get(Branch.class, 1);
			branch = new Branch();
			branch.setBranchName("Fedx Central Office");
			branch.setLocation("somajiguda");
			branch.setBranchManager("Philip");
			branch.setContactNo("989898835");
			branch.setEmailAddress("philip@fedx.com");
			branch.setPackages(branchPackages);
			session.save(branch);

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
