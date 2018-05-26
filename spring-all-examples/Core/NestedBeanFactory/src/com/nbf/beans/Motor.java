package com.nbf.beans;

public class Motor {
	private int id;
	private String motorType;

	public void setId(int id) {
		this.id = id;
	}

	public void setMotorType(String motorType) {
		this.motorType = motorType;
	}

	@Override
	public String toString() {
		return "Motor [id=" + id + ", motorType=" + motorType + "]";
	}

}
