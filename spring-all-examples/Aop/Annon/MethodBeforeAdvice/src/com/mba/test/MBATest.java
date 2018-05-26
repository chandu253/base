package com.mba.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mba.beans.LoanManager;
import com.mba.config.AppConfig;

public class MBATest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		LoanManager loanManager = context.getBean("loanManager", LoanManager.class);
		System.out.println("approved : ? " + loanManager.approveLoan("l984"));
		
	}
}





