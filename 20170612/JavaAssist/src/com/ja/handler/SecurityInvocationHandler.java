package com.ja.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SecurityInvocationHandler implements InvocationHandler {
	private Object object;

	public SecurityInvocationHandler(Object object) {
		this.object = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// apply additional functionality
		if (method.getName().equals("getBalance")) {
			System.out.println("authenticated...");
		}
		// execute the original logic
		return method.invoke(object, args);
	}

}



