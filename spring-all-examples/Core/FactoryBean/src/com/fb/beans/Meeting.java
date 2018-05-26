package com.fb.beans;

import java.util.Arrays;
import java.util.Calendar;

public class Meeting {
	private int meetingNo;
	private String description;
	private Calendar scheduledDate;
	private String[] participants;

	public void setMeetingNo(int meetingNo) {
		this.meetingNo = meetingNo;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setScheduledDate(Calendar scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	public void setParticipants(String[] participants) {
		this.participants = participants;
	}

	@Override
	public String toString() {
		return "Meeting [meetingNo=" + meetingNo + ", description=" + description + ", scheduledDate=" + scheduledDate.getTime()
				+ ", participants=" + Arrays.toString(participants) + "]";
	}

}
