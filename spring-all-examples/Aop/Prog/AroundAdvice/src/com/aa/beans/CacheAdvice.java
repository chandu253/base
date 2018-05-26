package com.aa.beans;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.aa.util.Cache;

public class CacheAdvice implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		String methodName = null;
		Object[] args = null;
		String key = null;
		Cache cache = null;

		methodName = methodInvocation.getMethod().getName();
		args = methodInvocation.getArguments();
		key = methodName + "(";
		for (int i = 0; i < args.length; i++) {
			if (i == 0) {
				key += args[i];
				continue;
			}
			key += "," + args[i];
		}
		key += ")";

		cache = Cache.getInstance();
		// if data is found inside the cache, don't execute target class method rather
		// return the value from cache
		if (cache.containskey(key) == true) {
			return cache.get(key);
		}
		// if not found
		Object ret = methodInvocation.proceed();
		cache.put(key, ret);

		return ret;
	}
}
