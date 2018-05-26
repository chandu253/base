package com.autowire.annon;

public class Sensor {
	private int sensorId;
	private String sensorType;

	public void setSensorId(int sensorId) {
		this.sensorId = sensorId;
	}

	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}

	@Override
	public String toString() {
		return "Sensor [sensorId=" + sensorId + ", sensorType=" + sensorType + "]";
	}

}
