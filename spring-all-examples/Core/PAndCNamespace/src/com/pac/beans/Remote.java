package com.pac.beans;

public class Remote {
	private int id;
	private String type;

	public Remote(int id, String type) {
		this.id = id;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Remote [id=" + id + ", type=" + type + "]";
	}

}
