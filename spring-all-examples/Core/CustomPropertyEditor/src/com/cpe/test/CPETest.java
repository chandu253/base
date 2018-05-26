package com.cpe.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.cpe.beans.Metal;
import com.cpe.util.CustomPropertyEditorRegistrar;

public class CPETest {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("com/cpe/common/application-context.xml"));
		CustomPropertyEditorRegistrar registrar = new CustomPropertyEditorRegistrar();
		((ConfigurableListableBeanFactory) factory).addPropertyEditorRegistrar(registrar);

		Metal metal = factory.getBean("metal", Metal.class);

		System.out.println(metal);
	}
}
