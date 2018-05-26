package com.decorator.event;

import java.util.Date;

public class TechnicalEvent implements Event {
	@Override
	public void organize(String place, Date eDate, int noOfParticipants) {
		System.out.println("organizing technical event with connectivity at place : " + place + " on : " + eDate
				+ " for members : " + noOfParticipants);
	}
}
