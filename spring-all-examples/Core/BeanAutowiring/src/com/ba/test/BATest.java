package com.ba.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.ba.beans.Robot;

public class BATest {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("com/ba/common/application-context.xml"));
		Robot robot = factory.getBean("robot", Robot.class);
		System.out.println(robot);
	}
}
