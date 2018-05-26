package com.ba.beans;

public class Mobile {
	private String imei;
	private String model;
	private String manufacturer;

	public void setImei(String imei) {
		this.imei = imei;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() {
		return "Mobile [imei=" + imei + ", model=" + model + ", manufacturer=" + manufacturer + "]";
	}

}
