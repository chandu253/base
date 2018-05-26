package com.flyweight.notification.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.flyweight.notification.FacebookNotification;
import com.flyweight.notification.MailNotification;
import com.flyweight.notification.Notification;

public class NotificationFactory {
	private static NotificationFactory instance;
	protected Map<String, Notification> notificationMap;

	private NotificationFactory() {
		notificationMap = new ConcurrentHashMap<>();
	}

	public static NotificationFactory getInstance() {
		if (instance == null) {
			synchronized (NotificationFactory.class) {
				if (instance == null) {
					instance = new NotificationFactory();
				}
			}
		}
		return instance;
	}

	public Notification getNotification(String type) {
		Notification notification = null;

		synchronized (notificationMap) {
			if (notificationMap.containsKey(type)) {
				notification = notificationMap.get(type);
			} else {
				if ("mail".equals(type)) {
					notification = new MailNotification(type);
				} else if ("facebook".equals(type)) {
					notification = new FacebookNotification(type);
				}
				notificationMap.put(type, notification);
			}
		}

		return notification;
	}
}
