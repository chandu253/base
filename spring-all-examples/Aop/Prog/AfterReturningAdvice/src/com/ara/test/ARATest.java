package com.ara.test;

import org.springframework.aop.framework.ProxyFactory;

import com.ara.beans.KeyGenerator;
import com.ara.beans.KeyVerifyAdvice;

public class ARATest {
	public static void main(String[] args) {
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(new KeyGenerator());
		pf.addAdvice(new KeyVerifyAdvice());

		KeyGenerator proxy = (KeyGenerator) pf.getProxy();
		int key = proxy.generateKey(9);
		System.out.println("key : " + key);
		key = proxy.generateKey(7);
		System.out.println("key : " + key);

	}
}
