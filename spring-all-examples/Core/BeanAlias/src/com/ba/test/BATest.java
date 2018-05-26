package com.ba.test;

import java.util.Properties;

public class BATest {
	public static void main(String[] args) {
		/*BeanFactory factory = new XmlBeanFactory(new ClassPathResource("com/ba/common/application-context.xml"));*/
		/*Mobile mobile = factory.getBean("galaxy,s8", Mobile.class);
		System.out.println(mobile);*/
		
		/*String[] aliases = factory.getAliases("s8");
		for(String alias : aliases) {
			System.out.println(alias);
		}*/
		
		Properties props = System.getProperties();
		for(Object prop : props.keySet()) {
			System.out.println(prop + " : " + props.getProperty((String)prop));
		}
		
		
	}
}
