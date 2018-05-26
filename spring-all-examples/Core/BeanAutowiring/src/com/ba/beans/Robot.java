package com.ba.beans;

public class Robot {
	private Chip chip;
	private Sensor sensor;

	public Robot(Chip chip) {
		this.chip = chip;
	}

	public Robot(Sensor sensor) {
		this.sensor = sensor;
	}
	@Override
	public String toString() {
		return "Robot [chip=" + chip + ", sensor=" + sensor + "]";
	}

}
