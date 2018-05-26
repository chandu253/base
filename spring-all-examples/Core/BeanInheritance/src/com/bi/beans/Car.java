package com.bi.beans;

import java.beans.ConstructorProperties;

public class Car {
	private int id;
	private String model;
	private String manufacturer;
	private String color;
	private String fuelType;

	@ConstructorProperties({ "id", "model", "manufacturer", "color", "fuelType" })
	public Car(int id, String model, String manufacturer, String color, String fuelType) {
		this.id = id;
		this.model = model;
		this.manufacturer = manufacturer;
		this.color = color;
		this.fuelType = fuelType;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", manufacturer=" + manufacturer + ", color=" + color
				+ ", fuelType=" + fuelType + "]";
	}

}
