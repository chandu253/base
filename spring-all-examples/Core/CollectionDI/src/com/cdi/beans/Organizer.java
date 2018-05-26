package com.cdi.beans;

import java.util.Map;
import java.util.Properties;

public class Organizer {
	private Map<String, Meeting> meetings;
	private Properties hosts;

	public void setHosts(Properties hosts) {
		this.hosts = hosts;
	}

	public void setMeetings(Map<String, Meeting> meetings) {
		this.meetings = meetings;
	}

	@Override
	public String toString() {
		return "Organizer [meetings=" + meetings + ", hosts=" + hosts + "]";
	}

}
