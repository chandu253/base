package com.mrt.test;

import org.springframework.aop.framework.ProxyFactory;

import com.mrt.beans.ManageSubscriber;
import com.mrt.beans.TopupNotifierAdvice;

public class MRTTest {
	public static void main(String[] args) {
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(new ManageSubscriber());
		pf.addAdvice(new TopupNotifierAdvice());
		
		ManageSubscriber proxy = (ManageSubscriber) pf.getProxy();
		proxy.recharge("9898373434", 101);
		
	}
}





