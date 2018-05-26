package com.qa.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qa.bo.CustomerBo;
import com.qa.bo.CustomerJobsheetBo;
import com.qa.bo.JobsheetBo;
import com.qa.dao.CustomerDao;

public class QATest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/qa/common/application-context.xml");
		CustomerDao cDao = context.getBean("customerDao", CustomerDao.class);
		/*
		 * int n = cDao.getNoOfCustomers(); System.out.println("count : "+ n);
		 */

		/*
		 * String firstName = cDao.findCustomerFirstName("998948948");
		 * System.out.println("firstName : " + firstName);
		 */

		/*
		 * CustomerBo bo = cDao.findCustomer(1); System.out.println(bo);
		 */

		/*
		 * List<CustomerBo> customers = cDao.getCustomers(); for (CustomerBo bo :
		 * customers) { System.out.println(bo); }
		 */

		/*
		 * List<CustomerJobsheetBo> customerJobsheets =
		 * cDao.getCustomersWithJobsheets(); for(CustomerJobsheetBo bo :
		 * customerJobsheets) { System.out.println(bo.getCustomer().getFirstName());
		 * List<JobsheetBo> jobsheets = bo.getJobsheets(); for(JobsheetBo jBo :
		 * jobsheets) { System.out.println(jBo.getJobsheetNo()); }
		 * System.out.println("----------------"); }
		 */

		/*
		 * List<JobsheetBo> jobsheets = cDao.getJobsheets(3, 2); for(JobsheetBo jbo :
		 * jobsheets) { System.out.println(jbo.getJobsheetNo()); }
		 */

		CustomerBo cBo = new CustomerBo();
		// cBo.setCustomerNo(4);
		cBo.setFirstName("Susan");
		cBo.setLastName("D");
		cBo.setMobile("989879453");
		cBo.setEmailAddress("susan1@gmail.com");
		// int r = cDao.saveCustomer(cBo);
		// System.out.println(r);
		long cNo = cDao.saveAutoGenCustomer(cBo);
		System.out.println("customer No :" + cNo);
	}
}





