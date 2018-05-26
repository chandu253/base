package com.sfm.beans;

import java.util.Calendar;
import java.util.List;

public class Meeting {
	private String agenda;
	private String description;
	private List<String> participants;
	private Calendar meetingDate;

	public void setAgenda(String agenda) {
		this.agenda = agenda;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setParticipants(List<String> participants) {
		this.participants = participants;
	}

	public void setMeetingDate(Calendar meetingDate) {
		this.meetingDate = meetingDate;
	}

	@Override
	public String toString() {
		return "Meeting [agenda=" + agenda + ", description=" + description + ", participants=" + participants
				+ ", meetingDate=" + meetingDate + "]";
	}

}
