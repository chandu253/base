package com.autowire.annon;

public class Chip {
	private int chipNo;
	private String chipType;

	public void setChipNo(int chipNo) {
		this.chipNo = chipNo;
	}

	public void setChipType(String chipType) {
		this.chipType = chipType;
	}

	@Override
	public String toString() {
		return "Chip [chipNo=" + chipNo + ", chipType=" + chipType + "]";
	}

}
