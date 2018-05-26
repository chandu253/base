package com.sdi.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Sensor {
	@Value("${sensorNo}")
	private String sensorNo;
	public void observe() {
		System.out.println("Sensor " + sensorNo + " is Observing...");
	}
}
