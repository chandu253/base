package com.jcaw.annon;

public class Robot {
	private Chip chip;

	public void work() {
		chip.process();
	}

	public void setChip(Chip chip) {
		this.chip = chip;
	}

}
