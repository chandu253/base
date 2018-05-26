package com.cc.test;

import org.aspectj.apache.bcel.util.ClassPath;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.cc.beans.Machine;

public class CCTest {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("com/cc/common/application-context.xml"));
		Machine machine = factory.getBean("machine", Machine.class);
		System.out.println(machine);
	}
}
