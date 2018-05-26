package com.singleton.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionTest {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> clazz = Class.forName("com.singleton.pattern.TimeZoneL");
		Constructor<?> defaultConstructor = clazz.getDeclaredConstructors()[0];
		defaultConstructor.setAccessible(true);
		Object obj1 = defaultConstructor.newInstance(null);
		Object obj2 = defaultConstructor.newInstance(null);
				
		
	}
}






