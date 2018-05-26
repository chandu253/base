package com.flyweight.channel;

import com.flyweight.notification.Notification;
import com.flyweight.notification.factory.NotificationFactory;

public class Channel {
	public void notify(String from, String to, String subject, String content) {
		Notification notification = null;
		NotificationFactory notificationFactory = null;

		notificationFactory = NotificationFactory.getInstance();
		// build mail notification
		for (int i = 0; i < 100; i++) {
			notification = notificationFactory.getNotification("facebook");
			notification.publish(from + i, to + i, subject + i, content + i);
		}
	}
}
