package com.cdi.beans;

import java.util.List;
import java.util.Set;

public class Meeting {
	private List<String> todo;
	private Set<String> participants;

	public Meeting(Set<String> participants) {
		this.participants = participants;
	}

	public void setTodo(List<String> todo) {
		this.todo = todo;
	}

	@Override
	public String toString() {
		return "Meeting [todo=" + todo + ", participants=" + participants + "participantsType : "
				+ participants.getClass().getName() + "]";
	}

}
