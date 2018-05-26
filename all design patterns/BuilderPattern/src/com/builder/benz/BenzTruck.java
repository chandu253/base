package com.builder.benz;

import com.builder.api.Truck;

public class BenzTruck extends Truck {

	public BenzTruck(int capacity, String engineType, String fuelType) {
		super(capacity, engineType, fuelType);
	}

	@Override
	protected int accelerate(int speed) {
		return speed + 10;
	}

}
