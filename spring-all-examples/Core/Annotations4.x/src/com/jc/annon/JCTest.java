package com.jc.annon;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JCTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		/*Radio radio1 = context.getBean("fmRadio", Radio.class);
		Radio radio2 = context.getBean("fmRadio", Radio.class);
		System.out.println("radio1 == radio2 ? : " + (radio1 == radio2));*/
		// radio.listen();
	}
}
