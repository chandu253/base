package com.req.annon;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class ReqTest {
	public static void main(String[] args) {
		/*
		 * BeanFactory factory = new XmlBeanFactory(new
		 * ClassPathResource("com/req/annon/application-context.xml"));
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("com/req/annon/application-context.xml");
		Rocket rocket = context.getBean("rocket", Rocket.class);
		System.out.println(rocket);
	}
}
