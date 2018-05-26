package com.automobiles.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.automobiles.bo.BillBo;
import com.automobiles.entities.Address;
import com.automobiles.entities.Customer;
import com.automobiles.entities.Dealer;
import com.automobiles.entities.Invoice;
import com.automobiles.entities.Jobsheet;
import com.automobiles.entities.Mechanic;
import com.automobiles.entities.RepairsConducted;
import com.automobiles.entities.ServiceCenter;
import com.automobiles.entities.Sparepart;
import com.automobiles.entities.Vehicle;
import com.automobiles.util.SessionFactoryResgistry;

public class AutomobilesHql {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		Boolean flag = false;
		try {
			sessionFactory = SessionFactoryResgistry.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			// showAddress(session);
			// findAddress(session, "n");
			// findJobsheetByTypeAndEstimatedAmount(session, "paid", 2000);
			// findJobSheetsWithStatusAndEta(session, "Processing", new Date());
			// findCountOfMechanicsByExperiences(session, 2);
			// findMaxInvoiceAmountOfTheDay(session);
			// findMaxKiloByJobSheetType(session);
			// findBillsByPaymentType(session, "Cash");
			// findSecondHighestPriceSparepart(session);
			// findNoOfSheetsByAdvisor(session);
			// findMaxColorVehicleModel(session);
			// findJobSheetByMechanic(session, 1);
			// findJobSheetsByCustomerMobile(session, 765897451);
			// findCustomersByArea(session, Arrays.asList(new String[] { "S r Nagar", "Road
			// No. 10" }));
			// getRepairsConductedByJobsheetNo(session, 1);
			// findMechanicsByBillNo(session, 2);
			// findServiceCentersByDelearCode(session, 2);
			// getServiceCentersByLocationsNamedQuery(session, Arrays.asList(new String[] {
			// "S r Nagar", "RoadNo.10" }));
			// getVehicles(session);
			// getHighUsageColors(session);

			// showAdressC(session);
			// findAddressC(session, "n");
			// findJobsheetByTypeAndEstimatedAmountC(session, "Paid", 2000);
			// findJobSheetsWithStatusAndEtaC(session, "Processing", new Date());
			// findCountOfMechanicsByExperiencesC(session, 2);
			// findMaxInvoiceAmountOfTheDayC(session);
			// getPartialDealerByFirstName(session, "a");
			// findMaxKiloByJobSheetTypeC(session);
			// findNoOfSheetsByAdvisorC(session);
			// findNoOfSheetsByForAllAdvisor(session);
			// findJobSheetByMechanicC(session, 1);
			// findJobSheetsByCustomerMobileC(session,765897451);
			// findCustomersByAreaC(session, Arrays.asList(new String[] { "S r Nagar",
			// "RoadNo.10" }));
			// getRepairsConductedByJobsheetNoC(session, 1);
			// findMechanicsByBillNoC(session, 1);
			// getDealerByMobile(session, 989897255);
			findDealerByEmailOrMobile(session, null, 989897255);
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
			SessionFactoryResgistry.closeSessionFactory();
		}
	}

	private static void showAddress(Session session) {
		Query query = session.createQuery("from Address");
		List<Address> addresses = query.list();
		for (Address address : addresses) {
			System.out.println(address);
		}
	}

	private static void showAdressC(Session session) {
		Criteria addressCriteria = null;

		// from Address
		addressCriteria = session.createCriteria(Address.class);
		List<Address> addresses = addressCriteria.list();
		for (Address addr : addresses) {
			System.out.println(addr);
		}
	}

	private static void findAddress(Session session, String location) {
		Query query = null;

		query = session.createQuery("from Address address where lower(address.addressLine1) like ?");
		query.setParameter(0, location.toLowerCase() + "%");
		List<Address> addresses = query.list();
		for (Address address : addresses) {
			System.out.println(address);
		}
	}

	private static void findAddressC(Session session, String location) {
		Criteria c = null;

		c = session.createCriteria(Address.class).add(Restrictions.like("addressLine1", "%" + location + "%"));
		List<Address> addresses = c.list();
		for (Address address : addresses) {
			System.out.println(address);
		}

	}

	private static void findJobsheetByTypeAndEstimatedAmount(Session session, String jobSheetType, int amount) {
		Query query = null;

		query = session.createQuery("from Jobsheet js where lower(js.jobSheetType) = ? and js.estimatedAmount >= ?");
		query.setParameter(0, jobSheetType.toLowerCase());
		query.setParameter(1, amount);
		List<Jobsheet> jobSheets = query.list();
		for (Jobsheet jobSheet : jobSheets) {
			System.out.println(
					jobSheet.getJobsheetNo() + " - " + jobSheet.getEstimatedAmount() + " - " + jobSheet.getStatus());
		}

	}

	private static void findJobsheetByTypeAndEstimatedAmountC(Session session, String jobSheetType, int amount) {
		Criteria c = null;

		c = session.createCriteria(Jobsheet.class).add(Restrictions.and(Restrictions.eq("jobSheetType", jobSheetType),
				Restrictions.gt("estimatedAmount", amount)));

		List<Jobsheet> jobsheets = c.list();
		for (Jobsheet js : jobsheets) {
			System.out.println(js.getJobsheetNo());
		}
	}

	private static void findJobSheetsWithStatusAndEta(Session session, String status, Date etaDate) {
		Query query = null;

		query = session.createQuery("from Jobsheet js where js.status = ? and js.deliveryEta = current_date()");
		query.setParameter(0, status);
		// query.setParameter(1, etaDate);
		List<Jobsheet> jobsheets = query.list();
		for (Jobsheet jobSheet : jobsheets) {
			System.out.println(
					jobSheet.getJobsheetNo() + " - " + jobSheet.getEstimatedAmount() + " - " + jobSheet.getStatus());
		}

	}

	private static void findJobSheetsWithStatusAndEtaC(Session session, String status, Date etaDate) {
		Criteria c = null;

		c = session.createCriteria(Jobsheet.class)
				.add(Restrictions.and(Restrictions.eq("status", status), Restrictions.eq("deliveryEta", etaDate)));
		List<Jobsheet> jobsheets = c.list();
		for (Jobsheet js : jobsheets) {
			System.out.println(js.getJobsheetNo());
		}
	}

	private static void findCountOfMechanicsByExperiences(Session session, int experience) {
		Query query = null;

		query = session.createQuery("select count(mechanic) from Mechanic mechanic where mechanic.experience > ?");
		query.setParameter(0, experience);
		List<Integer> l = query.list();
		System.out.println("experienced mechanics : " + l.get(0));
	}

	private static void findCountOfMechanicsByExperiencesC(Session session, int experience) {
		Criteria c = null;

		c = session.createCriteria(Mechanic.class).add(Restrictions.ge("experience", experience))
				.setProjection(Projections.rowCount());
		List<Integer> records = c.list();
		System.out.println(records.get(0));

	}

	private static void findMaxInvoiceAmountOfTheDay(Session session) {
		Query query = null;

		query = session.createQuery(
				"from Invoice iv where iv.invoiceAmount = (select max(siv.invoiceAmount) from Invoice siv where siv.invoiceDt = current_date()) and iv.invoiceDt = current_date()");
		List<Invoice> invoices = query.list();
		for (Invoice invoice : invoices) {
			System.out.println(invoice.getInvoiceNo() + " = " + invoice.getInvoiceAmount());
		}
	}

	private static void findMaxInvoiceAmountOfTheDayC(Session session) {
		Criteria ic = null;
		Criteria c = null;
		Date today = new Date();

		ic = session.createCriteria(Invoice.class).add(Restrictions.eq("invoiceDt", today))
				.setProjection(Projections.max("invoiceAmount"));
		c = session.createCriteria(Invoice.class).add(Restrictions
				.and(Restrictions.eq("invoiceAmount", ic.list().get(0)), Restrictions.eq("invoiceDt", today)));
		List<Invoice> invoices = c.list();
		for (Invoice i : invoices) {
			System.out.println(i.getInvoiceNo());
		}
	}

	private static void findMaxKiloByJobSheetType(Session session) {
		Query query = null;

		query = session
				.createQuery("select js.jobSheetType, max(js.kilometers) from Jobsheet js group by js.jobSheetType");
		List<Object[]> jobSheets = query.list();
		for (Object[] row : jobSheets) {
			System.out.println("Type : " + row[0] + " kilo : " + row[1]);
		}
	}

	private static void findMaxKiloByJobSheetTypeC(Session session) {
		Criteria c = session.createCriteria(Jobsheet.class).setProjection(Projections.projectionList()
				.add(Projections.groupProperty("jobSheetType")).add(Projections.max("kilometers")));
		List<Object[]> records = c.list();
		for (Object[] row : records) {
			System.out.println(row[0] + " - " + row[1]);
		}

	}

	private static void findBillsByPaymentType(Session session, String paymentType) {
		Query query = null;

		query = session.createQuery(
				"select new com.automobiles.bo.BillBo(b.billNo, b.billDt, b.amount) from Bill b where b.paymentType = ?");
		query.setParameter(0, paymentType);
		List<BillBo> bos = query.list();
		for (BillBo bo : bos) {
			System.out.println(bo);
		}
	}

	private static void findSecondHighestPriceSparepart(Session session) {
		Query query = null;

		query = session.createQuery(
				"from Sparepart sp where sp.price = (select max(ssp.price) from Sparepart ssp where ssp.price < (select max(sssp.price) from Sparepart sssp))");
		List<Sparepart> spareparts = query.list();
		System.out.println("Price: " + spareparts.get(0).getPrice());
	}

	private static void findNoOfSheetsByAdvisor(Session session) {
		Query query = null;

		query = session
				.createQuery("select count(1), js.advisor.advisorNo from Jobsheet js group by js.advisor.advisorNo");
		List<Object[]> records = query.list();
		for (Object[] row : records) {
			System.out.println(row[0] + " - " + row[1]);
		}
	}

	private static void findNoOfSheetsByForAllAdvisor(Session session) {
		Query query = null;

		query = session.createQuery(
				"select count(js.jobsheetNo), advisor.firstNm from Jobsheet js right outer join js.advisor advisor group by advisor.advisorNo");
		List<Object[]> records = query.list();
		for (Object[] row : records) {
			System.out.println(row[0] + " - " + row[1]);
		}
	}

	private static void findNoOfSheetsByAdvisorC(Session session) {
		Criteria c = session.createCriteria(Jobsheet.class)
				.createAlias("advisor", "jsAdvisor", JoinType.RIGHT_OUTER_JOIN)
				.setProjection(Projections.projectionList().add(Projections.groupProperty("jsAdvisor.advisorNo"))
						.add(Projections.property("jsAdvisor.firstNm")).add(Projections.count("jobsheetNo")));
		List<Object[]> records = c.list();
		for (Object[] row : records) {
			System.out.println(row[1] + " - " + row[2]);
		}
	}

	private static void findMaxColorVehicleModel(Session session) {
		Query query = null;

		query = session.createQuery("select count(1), v.color from Vehicle v group by v.color");
		List<Object[]> records = query.list();
		for (Object[] row : records) {
			System.out.println(row[1] + " - " + row[0]);
		}

	}

	private static void findJobSheetByMechanic(Session session, int mechanicNo) {
		Query query = null;

		query = session.createQuery(
				"select js from Jobsheet js inner join js.jobsheetMechanics jsm where jsm.mechanic.mechanicNo = ?");
		query.setParameter(0, mechanicNo);
		List<Jobsheet> jobSheets = query.list();
		for (Jobsheet js : jobSheets) {
			System.out.println(js.getJobsheetNo());
		}
	}

	private static void findJobSheetByMechanicC(Session session, int mechanicNo) {
		Criteria c = session.createCriteria(Jobsheet.class).createAlias("jobsheetMechanics", "jsm")
				.createAlias("jsm.mechanic", "jsmMechanic").add(Restrictions.eq("jsmMechanic.mechanicNo", mechanicNo));
		List<Jobsheet> jobsheets = c.list();
		for (Jobsheet js : jobsheets) {
			System.out.println(js.getJobsheetNo());
		}
	}

	private static void findJobSheetsByCustomerMobile(Session session, int mobile) {
		Query query = null;

		query = session.createQuery("select js from Jobsheet js inner join js.customer c where c.mobile = ?");
		query.setParameter(0, mobile);
		List<Jobsheet> jobSheets = query.list();
		for (Jobsheet js : jobSheets) {
			System.out.println(js.getJobsheetNo());
		}
	}

	private static void findJobSheetsByCustomerMobileC(Session session, int mobile) {
		Criteria c = session.createCriteria(Jobsheet.class).createAlias("customer", "c")
				.add(Restrictions.eq("c.mobile", mobile));
		List<Jobsheet> jobSheets = c.list();
		for (Jobsheet js : jobSheets) {
			System.out.println(js.getJobsheetNo());
		}
	}

	private static void findCustomersByArea(Session session, List<String> locations) {
		Query query = null;

		query = session
				.createQuery("select c from Customer c inner join c.address a where a.addressLine1 in (:locations)");
		query.setParameterList("locations", locations);
		List<Customer> customers = query.list();
		for (Customer customer : customers) {
			System.out.println(customer.getFirstNm());
		}
	}

	private static void findCustomersByAreaC(Session session, List<String> locations) {
		Criteria c = session.createCriteria(Customer.class).createAlias("address", "a")
				.add(Restrictions.in("a.addressLine1", locations));
		List<Customer> customers = c.list();
		for (Customer customer : customers) {
			System.out.println(customer.getFirstNm());
		}
	}

	private static void getRepairsConductedByJobsheetNo(Session session, int jobSheetNo) {
		Query query = null;

		query = session.createQuery(
				"select rc from RepairsConducted rc inner join rc.invoice rci inner join rci.jobsheet rcijs where rcijs.jobsheetNo = ?");
		query.setParameter(0, jobSheetNo);
		List<RepairsConducted> rcs = query.list();
		for (RepairsConducted rc : rcs) {
			System.out.println(rc.getRepairConducted());
		}
	}

	private static void getRepairsConductedByJobsheetNoC(Session session, int jobSheetNo) {
		Criteria c = session.createCriteria(RepairsConducted.class).createAlias("invoice", "iv")
				.createAlias("iv.jobsheet", "ivjs").add(Restrictions.eq("ivjs.jobsheetNo", jobSheetNo));
		List<RepairsConducted> rcs = c.list();
		for (RepairsConducted rc : rcs) {
			System.out.println(rc.getRepairConducted());
		}
	}

	private static void findMechanicsByBillNo(Session session, int billNo) {
		Query query = null;

		query = session.createQuery(
				"select m from Mechanic m inner join m.jobsheetMechanics jsm inner join jsm.jobsheet jsmjs inner join jsmjs.invoices jsmjsinvs inner join jsmjsinvs.bills jsmjsinvsb where jsmjsinvsb.billNo = ?");
		// query = session.createQuery("select m from Mechanic m where
		// m.jobsheetMechanics.jobsheet.invoices.bills.billNo = ?");
		query.setParameter(0, billNo);
		List<Mechanic> mechanics = query.list();
		for (Mechanic mechanic : mechanics) {
			System.out.println(mechanic.getFirstNm() + " - " + mechanic.getContactNo());
		}

	}

	private static void findMechanicsByBillNoC(Session session, int billNo) {
		Criteria c = session.createCriteria(Mechanic.class).createAlias("jobsheetMechanics", "jsm")
				.createAlias("jsm.jobsheet", "jsmj").createAlias("jsmj.invoices", "jsmjiv")
				.createAlias("jsmjiv.bills", "jsmjivb").add(Restrictions.eq("jsmjivb.billNo", billNo));
		List<Mechanic> mechanics = c.list();
		for (Mechanic mechanic : mechanics) {
			System.out.println(mechanic.getFirstNm() + " - " + mechanic.getContactNo());
		}

	}

	private static void findServiceCentersByDelearCode(Session session, int dealerCode) {
		Query query = null;

		query = session.createQuery(
				"select sc.serviceCenterNm, sc.address.addressLine1 from ServiceCenter sc where sc.dealer.dealerCode = ?");
		query.setParameter(0, dealerCode);
		List<Object[]> records = query.list();
		for (Object[] row : records) {
			System.out.println(row[0] + " - " + row[1]);
		}
	}

	private static void getServiceCentersByLocationsNamedQuery(Session session, List<String> locations) {
		Query query = null;

		query = session.getNamedQuery("serviceCentersByLocations");
		query.setParameterList("locations", locations);
		List<ServiceCenter> serviceCenters = query.list();
		for (ServiceCenter sc : serviceCenters) {
			System.out.println(sc.getServiceCenterNm());
		}
	}

	private static void getVehicles(Session session) {
		SQLQuery sqlQuery = null;

		sqlQuery = session.createSQLQuery("select * from vehicle");
		sqlQuery.addEntity(Vehicle.class);
		List<Vehicle> vehicles = sqlQuery.list();
		for (Vehicle v : vehicles) {
			System.out.println(v.getVehicleModelNm());
		}

	}

	private static void getHighUsageColors(Session session) {
		SQLQuery sqlQuery = null;

		sqlQuery = session.createSQLQuery(
				"select color from Vehicle group by color having count(1) >= (select max(omytab.onvehicles) from (select count(1) as onvehicles from Vehicle vo group by vo.color having onvehicles < (select max(mytab.nvehicles) from (select count(1) as nvehicles, v.color from vehicle v group by v.color) mytab)) omytab)");
		List<String> colors = sqlQuery.list();
		for (String color : colors) {
			System.out.println(color);
		}
	}

	private static void getPartialDealerByFirstName(Session session, String firstName) {
		Criteria c = session.createCriteria(Dealer.class).add(Restrictions.like("dealerNm", "%" + firstName + "%"))
				.setProjection(Projections.projectionList().add(Projections.property("dealerNm"))
						.add(Projections.property("emailAddress")).add(Projections.property("contactNo")));
		List<Object[]> records = c.list();
		for (Object[] row : records) {
			System.out.println(row[0] + " - " + row[1] + " - " + row[2]);
		}
	}

	private static DetachedCriteria getDealerDetachedCriteria() {
		DetachedCriteria dc = DetachedCriteria.forClass(Dealer.class)
				.setProjection(Projections.projectionList().add(Projections.property("dealerNm")));
		return dc;

	}
	
	private static void getDealerByEmailAddress(Session session, String emailAddress) {
		DetachedCriteria dc = getDealerDetachedCriteria();
		dc.add(Restrictions.eq("emailAddress", emailAddress));
		Criteria c = dc.getExecutableCriteria(session);
		List<String> dealerNames = c.list();
		for(String name : dealerNames) {
			System.out.println(name);
		}
	}

	private static void getDealerByMobile(Session session, int mobile) {
		DetachedCriteria dc = getDealerDetachedCriteria();
		dc.add(Restrictions.eq("contactNo", mobile));
		Criteria c = dc.getExecutableCriteria(session);
		List<String> dealerNames = c.list();
		for(String name : dealerNames) {
			System.out.println(name);
		}
	}
	
	private static void findDealerByEmailOrMobile(Session session, String email, Integer contactNo) {
		Dealer d = new Dealer();
		d.setEmailAddress(email);
		d.setContactNo(contactNo);
		
		Criteria c = session.createCriteria(Dealer.class).add(Example.create(d));
		List<Dealer> dealers = c.list();
		for(Dealer dealer : dealers) {
			System.out.println(dealer.getDealerNm());
		}
	}
}











