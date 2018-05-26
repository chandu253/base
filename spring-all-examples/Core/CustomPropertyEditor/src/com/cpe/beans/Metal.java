package com.cpe.beans;

public class Metal {
	private String metalName;
	private Dimensions dimensions;

	public void setMetalName(String metalName) {
		this.metalName = metalName;
	}

	public void setDimensions(Dimensions dimensions) {
		this.dimensions = dimensions;
	}

	@Override
	public String toString() {
		return "Metal [metalName=" + metalName + ", dimensions=" + dimensions + "]";
	}

}
