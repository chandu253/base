package com.ib.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.ib.beans.BiCycle;

public class IBTest {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("com/ib/common/application-context.xml"));
		BiCycle biCycle = factory.getBean("biCycle", BiCycle.class);
		System.out.println(biCycle);
	}
}
