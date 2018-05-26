package com.ai.beans;

public class LowFrequencyReceiver implements IReceiver {
	private int frequency;

	@Override
	public void tune(int frequency) {
		this.frequency = frequency;
	}

	@Override
	public String receive() {
		return "Low Frequency receiver is transmitting at : " + frequency;
	}

}




