package com.mssc.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mssc.bo.CustomerBo;
import com.mssc.dao.CustomerDao;

public class MSSCTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/mssc/common/application-context.xml");
		CustomerDao cDao = context.getBean("customerDao", CustomerDao.class);

		cDao.updateCustomer("Spider", "Women", 1);
		List<CustomerBo> customers = cDao.getCustomers("%i%");
		for(CustomerBo bo : customers) {
			System.out.println(bo);
		}
	}
}







