package com.singleton.test;

import com.singleton.thread.Task;

public class MultiThreadTimeZoneLTest {
	public static void main(String[] args) {
		Task task = new Task();
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(task, "thread-" + i);
			t.start();
		}
	}
}
