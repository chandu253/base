package com.ifmi.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.ifmi.beans.GeoMapUI;

public class IFMITest {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("com/ifmi/common/application-context.xml"));
		GeoMapUI ui = factory.getBean("geoMapUI", GeoMapUI.class);
		
		ui.render("ameerpet", "Madhapur");
	}
}



