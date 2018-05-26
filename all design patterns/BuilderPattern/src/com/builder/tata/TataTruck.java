package com.builder.tata;

import com.builder.api.Truck;

public class TataTruck extends Truck {

	public TataTruck(int capacity, String engineType, String fuelType) {
		super(capacity, engineType, fuelType);
	}

	@Override
	protected int accelerate(int speed) {
		return speed;
	}

}
