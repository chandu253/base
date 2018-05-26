package com.nbf.beans;

public class Toy {
	private Motor motor;

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	@Override
	public String toString() {
		return "Toy [motor=" + motor + "]";
	}

}
