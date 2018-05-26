package com.val.annon;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ValTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/val/annon/val-context.xml");
		Reciever reciever = context.getBean("reciever", Reciever.class);
		System.out.println(reciever);
	}
}
