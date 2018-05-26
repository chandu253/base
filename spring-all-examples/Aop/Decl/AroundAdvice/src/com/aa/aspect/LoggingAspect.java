package com.aa.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
	public Object log(ProceedingJoinPoint proceedingJoinPoint, int i, int j) throws Throwable {
		String methodName = null;
		// Object[] args = null;

		methodName = proceedingJoinPoint.getSignature().getName();
		// args = proceedingJoinPoint.getArgs();

		System.out.print("entered into " + methodName + "(" + i + "," + j + ")");
		/*
		 * for (int i = 0; i < args.length; i++) { if (i == 0) {
		 * System.out.print(args[i]); continue; } System.out.print("," + args[i]); }
		 * System.out.println(")");
		 */
		Object ret = proceedingJoinPoint.proceed();
		System.out.println("exiting from " + methodName + " with ret : " + ret);
		return ret;
	}
}
