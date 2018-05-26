package com.aa.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect extends GlobalPointcut {
	@Around("commonPointcut()")
	public Object log(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println(
				"entered into " + pjp.getSignature().getName() + "(" + pjp.getArgs()[0] + "," + pjp.getArgs()[1] + ")");
		Object ret = pjp.proceed();
		System.out.println("exiting from " + pjp.getSignature().getName() + " with ret : " + ret);
		return ret;
	}
}
