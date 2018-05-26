package com.bpp.beans;

import java.util.concurrent.atomic.AtomicInteger;

public class Tracker {
	protected static AtomicInteger counter = new AtomicInteger(0);

	public static void increment() {
		counter.incrementAndGet();
	}

	public static int getCounter() {
		return counter.get();
	}
}
