package com.singleton.test;

import com.singleton.pattern.TimeZoneL;

public class TimeZoneLTest {
	public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {
		TimeZoneL tzl1 = TimeZoneL.getInstance();
		TimeZoneL tzl2 = (TimeZoneL) tzl1.clone();
	}
}
