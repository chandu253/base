package com.dc.beans;

public class Toy {
	private int toy;
	private String toyName;
	private Motor motor;

	public Toy() {
		System.out.println("Toy()");
	}

	public void setToy(int toy) {
		System.out.println("setToy()");
		this.toy = toy;
	}

	public void setToyName(String toyName) {
		System.out.println("setToyName()");
		this.toyName = toyName;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	@Override
	public String toString() {
		return "Toy [toy=" + toy + ", toyName=" + toyName + ", motor=" + motor + "]";
	}

}
