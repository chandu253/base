package com.decorator.test;

import java.util.Date;

import com.decorator.event.Event;
import com.decorator.event.LivePresentationEvent;
import com.decorator.event.TechnicalEvent;
import com.decorator.event.VideoConferencingEvent;

public class DecoratorTest {
	public static void main(String[] args) {
		Event event = new LivePresentationEvent(new VideoConferencingEvent(new TechnicalEvent()));
		event.organize("hitex", new Date(), 2000);
	}
}




