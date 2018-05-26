package com.ta.beans;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class GlobalExceptionLoggingAdvice implements ThrowsAdvice {
	/*public void afterThrowing(Method method, Object[] args, Object target, IllegalArgumentException e) {
		System.out.println("message :" + e.getMessage() + " reported by method : " + method.getName());
	}*/

	public void afterThrowing(Exception e) {
		System.out.println("message : " + e.getMessage());
	}

}
