package com.decorator.event;

import java.util.Date;

// abstract decorator
public abstract class AdvancedEvent implements Event {
	// wrap the object for which you want to add additional functionality
	protected Event event;

	public AdvancedEvent(Event event) {
		this.event = event;
	}

	@Override
	public void organize(String place, Date eDate, int noOfParticipants) {
		event.organize(place, eDate, noOfParticipants);
	}

}
