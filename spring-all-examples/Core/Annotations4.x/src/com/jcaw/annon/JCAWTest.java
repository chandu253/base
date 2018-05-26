package com.jcaw.annon;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JCAWTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfigAutoWire.class);
		Robot robot = context.getBean("andriod", Robot.class);
		robot.work();
	}
}
