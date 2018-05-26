package com.singleton.pattern;

import java.io.Serializable;

/**
 * Lazy Instantiation Technic
 * 
 * @author sriman
 *
 */
abstract public class TimeZoneL implements Cloneable, Serializable {
	private static TimeZoneL instance;

	private TimeZoneL() {
		System.out.println("TimeZoneL instantiated");
	}

	public static TimeZoneL getInstance() throws InterruptedException {
		if (instance == null) {
			synchronized (TimeZoneL.class) {
				if (instance == null) {
					// anonymous inner class to avoid creation of the object through reflection
					instance = new TimeZoneL() {
					};
				}
			}
		}

		return instance;
	}

	public Object readResolve() {
		TimeZoneL timeZone = null;
		try {
			timeZone = TimeZoneL.getInstance();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return timeZone;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("clone is not supported");
	}
}
