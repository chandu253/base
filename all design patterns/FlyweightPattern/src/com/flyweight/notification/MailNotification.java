package com.flyweight.notification;

public class MailNotification implements Notification {
	protected String type;

	public MailNotification(String type) {
		this.type = type;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void publish(String from, String to, String subject, String content) {
		System.out.println("publishing " + getType() + " from : " + from + " to : " + to + " with subject : " + subject
				+ " of content : " + content + " with instance : " + this.hashCode());
	}

}
