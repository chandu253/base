package com.sdp.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppFactory {
	public static Object createObject(String lClazz)
			throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Properties props = new Properties();
		InputStream is = AppFactory.class.getClassLoader().getResourceAsStream("com/sdp/common/appClasses.properties");
		props.load(is);

		String className = props.getProperty(lClazz);
		Class aClass = Class.forName(className);
		Object obj = aClass.newInstance();
		return obj;
	}
}
