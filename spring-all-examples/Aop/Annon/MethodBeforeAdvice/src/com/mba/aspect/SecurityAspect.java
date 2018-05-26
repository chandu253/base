package com.mba.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mba.helper.AuthenticationHelper;

@Component
@Aspect
public class SecurityAspect {
	@Autowired
	private AuthenticationHelper authenticationHelper;

	@Pointcut("within(com.mba.beans.*)")
	public void securityPointcut() {
	}

	@Before("securityPointcut()")
	public void audit(JoinPoint jp) {
		System.out.println("john called " + jp.getSignature().getName());
	}

	@Before("securityPointcut()")
	public void authenticate(JoinPoint jp) throws IllegalAccessException {
		if (authenticationHelper.authentication() == false) {
			throw new IllegalAccessException("invalid un/pwd");
		}
	}
}
