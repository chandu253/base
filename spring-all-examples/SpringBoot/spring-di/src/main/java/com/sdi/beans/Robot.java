package com.sdi.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Robot {
	@Autowired
	private Sensor sensor;
	@Autowired
	private Chip chip;

	public void walk() {
		sensor.observe();
		chip.showShip();
		System.out.println("walking");
	}
}
