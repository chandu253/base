package com.req.annon;

import org.springframework.beans.factory.annotation.Required;

public class Rocket {
	private int threshold;
	private int level;

	@Required
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Rocket [threshold=" + threshold + ", level=" + level + "]";
	}

}
