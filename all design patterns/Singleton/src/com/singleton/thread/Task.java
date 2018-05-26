package com.singleton.thread;

import com.singleton.pattern.TimeZoneL;

public class Task implements Runnable {
	@Override
	public void run() {
		TimeZoneL tzl;
		try {
			tzl = TimeZoneL.getInstance();
			System.out.println("hashCode : " + tzl.hashCode());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
