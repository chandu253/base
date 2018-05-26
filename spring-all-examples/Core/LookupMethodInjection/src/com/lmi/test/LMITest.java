package com.lmi.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.lmi.beans.Container;

public class LMITest {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("com/lmi/common/application-context.xml"));
		Container container = factory.getBean("container", Container.class);
		container.recieve("data1");
		container.recieve("data2");
	}
}







