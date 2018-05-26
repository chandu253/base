package com.sp.test;

import java.util.Properties;

public class SPTest {
	public static void main(String[] args) {
		Properties props = null;
		props = System.getProperties();
		for (Object prop : props.keySet()) {
			System.out.println(prop + " = " + props.getProperty((String)prop));
		}
	}
}
