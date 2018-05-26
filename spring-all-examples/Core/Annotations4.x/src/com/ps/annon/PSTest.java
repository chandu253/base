package com.ps.annon;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PSTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.ps.annon");
		Toy toy = context.getBean("toy", Toy.class);
		System.out.println(toy);
	}
}





