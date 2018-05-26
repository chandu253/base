package com.bpp.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.bpp.beans.EBook;
import com.bpp.beans.Tracker;

public class BPPTest {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("com/bpp/common/application-context.xml"));
		BeanPostProcessor bpp = factory.getBean("instanceTrackerBeanPostProcessor", BeanPostProcessor.class);
		// register bean post process with ioc container
		((ConfigurableListableBeanFactory) factory).addBeanPostProcessor(bpp);
		EBook book = factory.getBean("ebook", EBook.class);
		System.out.println("Instances : " + Tracker.getCounter());
		factory.getBean("video");
		System.out.println("Instances : " + Tracker.getCounter());
	}
}
