package com.ib.beans;

public class BiCycle {
	private int id;
	private String manufacturer;
	private Chain chain;

	public void setId(int id) {
		this.id = id;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setChain(Chain chain) {
		this.chain = chain;
	}

	@Override
	public String toString() {
		return "BiCycle [id=" + id + ", manufacturer=" + manufacturer + ", chain=" + chain + "]";
	}

}
