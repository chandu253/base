package com.bl.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.bl.beans.Rocket;
import com.bl.beans.ShutdownHook;

public class BLTest {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("com/bl/common/application-context.xml"));
		ShutdownHook shutdownHook = factory.getBean("shutdownHook", ShutdownHook.class);

		Runtime runtime = Runtime.getRuntime();
		runtime.addShutdownHook(new Thread(shutdownHook)); // registered with
															// jvm

		Rocket rocket = factory.getBean("rocket", Rocket.class);
		System.out.println(rocket);
		System.out.println("finished");

	}
}
