package com.cpe.beans;

public class Dimensions {
	private int length;
	private int width;
	private int thickness;

	public void setLength(int length) {
		this.length = length;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setThickness(int thickness) {
		this.thickness = thickness;
	}

	@Override
	public String toString() {
		return "Dimensions [length=" + length + ", width=" + width + ", thickness=" + thickness + "]";
	}

}
