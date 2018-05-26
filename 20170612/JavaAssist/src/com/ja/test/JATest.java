package com.ja.test;

import java.lang.reflect.Proxy;

import com.ja.bean.BankingService;
import com.ja.bean.IBankingService;
import com.ja.handler.SecurityInvocationHandler;

public class JATest {
	public static void main(String[] args) {
		IBankingService bankingService = null;
		SecurityInvocationHandler securityInvocationHandler = null;
		IBankingService proxy = null;

		bankingService = new BankingService();
		securityInvocationHandler = new SecurityInvocationHandler(bankingService);
		proxy = (IBankingService) Proxy.newProxyInstance(JATest.class.getClassLoader(),
				new Class[] { IBankingService.class }, securityInvocationHandler);
		double balance = proxy.getBalance("ac39");
		System.out.println("balance : " + balance);
	}
}
