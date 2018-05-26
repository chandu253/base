package com.flyweight.notification;

public interface Notification {
	String getType();

	void publish(String from, String to, String subject, String content);
}
