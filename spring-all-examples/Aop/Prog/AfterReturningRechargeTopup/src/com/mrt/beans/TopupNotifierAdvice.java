package com.mrt.beans;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class TopupNotifierAdvice implements AfterReturningAdvice {
	@Override
	public void afterReturning(Object ret, Method method, Object[] args, Object target) throws Throwable {
		String mobileNumber = null;
		Float amount = null;

		mobileNumber = (String) args[0];
		amount = (Float) args[1];
		System.out.println(
				"199 full value topup is allowed for a recharge of " + amount + " on your mobile : " + mobileNumber);
	}
}
