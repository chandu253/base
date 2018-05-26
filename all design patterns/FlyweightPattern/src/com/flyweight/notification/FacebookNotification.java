package com.flyweight.notification;

public class FacebookNotification implements Notification {
	protected String type;

	public FacebookNotification(String type) {
		this.type = type;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void publish(String from, String to, String subject, String content) {
		System.out
				.println("posting on " + getType() + " from : " + from + " to : " + to + " with content : " + content);
	}

}
