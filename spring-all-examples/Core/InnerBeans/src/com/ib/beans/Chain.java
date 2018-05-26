package com.ib.beans;

public class Chain {
	private int id;
	private String length;

	public Chain(int id, String length) {
		this.id = id;
		this.length = length;
	}

	@Override
	public String toString() {
		return "Chain [id=" + id + ", length=" + length + "]";
	}

}
