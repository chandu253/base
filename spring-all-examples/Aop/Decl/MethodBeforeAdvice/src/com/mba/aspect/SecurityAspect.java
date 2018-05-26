package com.mba.aspect;

import org.aspectj.lang.JoinPoint;

import com.mba.helper.AuthenticationHelper;

public class SecurityAspect {
	private AuthenticationHelper authenticationHelper;

	public void audit(JoinPoint jp) {
		System.out.println(authenticationHelper.getLoggedInUser() + " called : " + jp.getSignature().getName());
	}

	public void verify(JoinPoint jp) {
		if (authenticationHelper.authentication() == false) {
			throw new IllegalAccessError("invalid un/pwd");
		}
	}

	public void setAuthenticationHelper(AuthenticationHelper authenticationHelper) {
		this.authenticationHelper = authenticationHelper;
	}

}
