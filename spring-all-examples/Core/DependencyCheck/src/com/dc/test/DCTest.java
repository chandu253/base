package com.dc.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.dc.beans.Toy;

public class DCTest {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("com/dc/common/application-context.xml"));
		Toy toy = (Toy) factory.getBean("toy");
		System.out.println(toy);
	}
}





