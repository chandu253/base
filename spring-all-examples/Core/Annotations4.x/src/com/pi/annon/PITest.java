package com.pi.annon;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PITest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(PJavaConfig.class);
		Rectangle rectangle = context.getBean("rectangle", Rectangle.class);
		System.out.println(rectangle);
	}
}
