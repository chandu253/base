package com.ai.beans;

public class HighFrequencyReceiver implements IReceiver {
	private int frequency;

	@Override
	public void tune(int frequency) {
		this.frequency = frequency;
	}

	@Override
	public String receive() {
		return "High Frequency Receiver is transmitting at : " + frequency;
	}

}
