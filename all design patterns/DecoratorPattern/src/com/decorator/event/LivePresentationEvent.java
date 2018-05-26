package com.decorator.event;

import java.util.Date;

public class LivePresentationEvent extends AdvancedEvent {

	public LivePresentationEvent(Event event) {
		super(event);
	}

	@Override
	public void organize(String place, Date eDate, int noOfParticipants) {
		super.organize(place, eDate, noOfParticipants);
		System.out.println("add live streaming support");
	}

}




