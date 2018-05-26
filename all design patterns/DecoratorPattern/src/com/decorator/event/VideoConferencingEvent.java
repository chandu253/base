package com.decorator.event;

import java.util.Date;

public class VideoConferencingEvent extends AdvancedEvent {

	public VideoConferencingEvent(Event event) {
		super(event);
	}

	@Override
	public void organize(String place, Date eDate, int noOfParticipants) {
		super.organize(place, eDate, noOfParticipants);
		System.out.println("adding video conferencing setup");
	}

}
