package com.singleton.pattern;

/**
 * Eager Instantiation Technic
 * 
 * @author sriman
 *
 */
public class TimeZoneEI {
	private static TimeZoneEI instance = new TimeZoneEI();

	// this is executed only once
	private TimeZoneEI() {
		System.out.println("TimeZoneEI() instantiated");
	}

	public static TimeZoneEI getInstance() {
		return instance;
	}
}
