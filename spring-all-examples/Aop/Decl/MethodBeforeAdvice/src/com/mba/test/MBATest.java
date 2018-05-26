package com.mba.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mba.beans.LoanManager;

public class MBATest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/mba/common/application-context.xml");
		LoanManager loanManager = context.getBean("loanManager", LoanManager.class);

		boolean status = loanManager.approveLoan("l1424");
		System.out.println("status : " + status);
	}
}
