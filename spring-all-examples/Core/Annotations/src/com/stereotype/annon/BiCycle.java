package com.stereotype.annon;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("atlas-bicycle")
@Lazy
public class BiCycle {
	
	public BiCycle() {
		System.out.println("biCycle()");
	}

	public void ride() {
		System.out.println("riding...");
	}
}
