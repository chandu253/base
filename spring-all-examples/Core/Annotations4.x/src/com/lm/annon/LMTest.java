package com.lm.annon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.ApplicationContext;

public class LMTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.lm.annon");
		Container container = context.getBean("container", Container.class);
		container.recieve("data1");
		container.recieve("Data2");
	}
}
