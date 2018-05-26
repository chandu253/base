package com.cdi.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.cdi.beans.Organizer;

public class CDITest {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("com/cdi/common/application-context.xml"));
		Organizer organizer = factory.getBean("organizer", Organizer.class);
		System.out.println(organizer);
	}
}
