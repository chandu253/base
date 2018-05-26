package com.singleton.test;

import com.singleton.pattern.TimeZoneSBI;

public class TimeZoneSBITest {
	public static void main(String[] args) throws ClassNotFoundException {
		/*TimeZoneSBI tzsbi1 = TimeZoneSBI.getInstance();
		TimeZoneSBI tzsbi2 = TimeZoneSBI.getInstance();
		System.out.println("tzsbi1 : " + tzsbi1.hashCode() + " - tzsbi2 : " + tzsbi2.hashCode());*/
		
		Class.forName("com.singleton.pattern.TimeZoneSBI");
		System.out.println("application loaded...");
		
	}
}








