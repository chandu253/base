package com.un.beans;

public class Address {
	private String addressLine1;

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	@Override
	public String toString() {
		return "Address [addressLine1=" + addressLine1 + "]";
	}

}
