package com.singleton.test;

import com.singleton.pattern.TimeZoneEI;

public class TimeZoneEITest {
	public static void main(String[] args) throws ClassNotFoundException {
		/*TimeZoneEI tzei1 = TimeZoneEI.getInstance();
		TimeZoneEI tzei2 = TimeZoneEI.getInstance();
		System.out.println("tzei1 : " +tzei1.hashCode() + " - tzei2 : " + tzei2.hashCode());*/
		
		Class.forName("com.singleton.pattern.TimeZoneEI");
		System.out.println("application loaded..");
	}
}






