package com.singleton.pattern;

/**
 * Static-Block Instantiation Technic
 * 
 * @author sriman
 *
 */
public class TimeZoneSBI {
	private static TimeZoneSBI instance;

	// this will be called only once, so only one object of this class will be
	// created
	static {
		System.out.println("in static-block instantiation technic, i can perform pre/post instantiation logic");
		instance = new TimeZoneSBI();

	}

	private TimeZoneSBI() {
		// no logic
	}

	public static TimeZoneSBI getInstance() {
		return instance;
	}

}
