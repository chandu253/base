package com.decorator.event;

import java.util.Date;

public class CorporateEvent implements Event {
	@Override
	public void organize(String place, Date eDate, int noOfParticipants) {
		System.out.println(
				"organizing corporate event at  : " + place + " on : " + eDate + " for members : " + noOfParticipants);
	}

}
