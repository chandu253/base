package com.val.annon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Reciever {
	@Value("#{fieldvalues.Reciever_frequency}")
	private int frequency;

	@Override
	public String toString() {
		return "Reciever [frequency=" + frequency + "]";
	}

}
