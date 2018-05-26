package com.aa.aspect;

import org.aspectj.lang.annotation.Pointcut;

public abstract class GlobalPointcut {
	@Pointcut("execution(* com.aa.beans.*.*(..))")
	public void commonPointcut() {
	}
}
