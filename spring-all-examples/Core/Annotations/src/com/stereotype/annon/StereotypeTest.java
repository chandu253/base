package com.stereotype.annon;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StereotypeTest {
	public static void main(String[] args) {
		/*ApplicationContext context = new ClassPathXmlApplicationContext("com/stereotype/annon/stereotype-context.xml");*/
		/*BiCycle biCycle1 = context.getBean("atlas-bicycle", BiCycle.class);
		BiCycle biCycle2 = context.getBean("atlas-bicycle", BiCycle.class);
		System.out.println("biCycle1 == biCycle2 : ? " + (biCycle1==biCycle2));*/
		ApplicationContext context = new AnnotationConfigApplicationContext("com.stereotype.annon");
		BiCycle biCycle2 = context.getBean("atlas-bicycle", BiCycle.class);
		biCycle2.ride();
	}
}














