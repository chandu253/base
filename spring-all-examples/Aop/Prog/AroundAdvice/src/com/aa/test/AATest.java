package com.aa.test;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.aa.beans.CacheAdvice;
import com.aa.beans.Calculator;
import com.aa.beans.DynamicPointcut;
import com.aa.beans.LoggingAdvice;
import com.aa.beans.LoggingPointcut;

public class AATest {
	public static void main(String[] args) {
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(new Calculator());
		// pf.addAdvice(new CacheAdvice());
		// pf.addAdvice(new LoggingAdvice());
		pf.addAdvisor(new DefaultPointcutAdvisor(new DynamicPointcut(), new LoggingAdvice()));

		Calculator proxy = (Calculator) pf.getProxy();
		int sum = proxy.add(101, 201);
		System.out.println("sum : " + sum);

		int multiply = proxy.multiply(10, 20);
		System.out.println("multiply : " + multiply);
	}
}




