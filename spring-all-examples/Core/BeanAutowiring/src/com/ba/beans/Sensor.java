package com.ba.beans;

public class Sensor {
	private int id;
	private String sensorType;

	public void setId(int id) {
		this.id = id;
	}

	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}

	@Override
	public String toString() {
		return "Sensor [id=" + id + ", sensorType=" + sensorType + "]";
	}

}
