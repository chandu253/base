package com.builder.benz.builder;

import com.builder.api.Truck;
import com.builder.api.builder.TruckBuilder;
import com.builder.benz.BenzTruck;

public class BenzTruckBuilder extends TruckBuilder {

	public BenzTruckBuilder(Integer capacity, String engineType, String fuelType) {
		super(capacity, engineType, fuelType);
	}

	@Override
	protected Truck createTruck() {
		Truck truck = null;

		truck = new BenzTruck(capacity, engineType, fuelType);
		return truck;
	}

}
