package com.ta.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GlobalExceptionLoggingAspect {
	@AfterThrowing(value = "within(com.ta.beans.*)", throwing = "iae")
	public void logException(JoinPoint jp, IllegalArgumentException iae) {
		System.out.println(
				"exception reported by " + jp.getSignature().getName() + " with message : " + iae.getMessage());
	}
}
