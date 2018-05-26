package com.autowire.annon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Robot {
	private Chip chip;

	@Autowired
	@Qualifier("chipi7")
	public void setChip(Chip chip) {
		this.chip = chip;
	}

	@Override
	public String toString() {
		return "Robot [chip=" + chip + "]";
	}

}
