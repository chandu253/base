package com.ta.aspect;

import org.aspectj.lang.JoinPoint;

public class GlobalExceptionLoggingAspect {
	public void logException(JoinPoint jp, IllegalArgumentException iae) {
		System.out
				.println("exception thrown by " + jp.getSignature().getName() + " with message : " + iae.getMessage());
	}
}
