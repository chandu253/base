package com.stackspace.beans;

public class Toy {
	private int toyId;
	private String toyName;

	public int getToyId() {
		return toyId;
	}

	public void setToyId(int toyId) {
		this.toyId = toyId;
	}

	public String getToyName() {
		return toyName;
	}

	public void setToyName(String toyName) {
		this.toyName = toyName;
	}

	@Override
	public String toString() {
		return "Toy [toyId=" + toyId + ", toyName=" + toyName + "]";
	}

}
