package com.ara.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class KeyCheckAspect {
	@AfterReturning(value = "target(com.ara.beans.KeyGenerator)", returning = "key")
	public void check(JoinPoint jp, Object key) {
		if ((Integer) key <= 0) {
			throw new IllegalArgumentException("invalid len");
		}
	}
}
