package com.stackspace.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.stackspace.beans.Toy;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/stackspace/common/application-context.xml");
		Toy toy = context.getBean("toy", Toy.class);
		System.out.println(toy);
	}
}










