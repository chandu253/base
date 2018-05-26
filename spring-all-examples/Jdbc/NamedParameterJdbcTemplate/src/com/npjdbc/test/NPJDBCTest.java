package com.npjdbc.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.npjdbc.bo.CustomerBo;
import com.npjdbc.dao.CustomerDao;

public class NPJDBCTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/npjdbc/common/application-context.xml");
		CustomerDao cDao = context.getBean("customerDao", CustomerDao.class);
		/*int n = cDao.getNoOfCustomers("%a%", "%a%");
		System.out.println("no : " + n);*/
		
		/*List<CustomerBo> customers = cDao.getCustomers("%a%");
		for(CustomerBo bo : customers) {
			System.out.println(bo);
		}*/
		/*CustomerBo bo = new CustomerBo();
		bo.setCustomerNo(5);
		bo.setFirstName("Rod");
		bo.setLastName("A");
		bo.setMobile("9392734");
		bo.setEmailAddress("rod@gmail.com");
		
		cDao.saveCustomer(bo);*/
		
		cDao.add(10, 20);
		
	}
}















