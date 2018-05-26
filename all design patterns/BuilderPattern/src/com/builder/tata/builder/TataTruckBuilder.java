package com.builder.tata.builder;

import com.builder.api.Truck;
import com.builder.api.builder.TruckBuilder;
import com.builder.tata.TataTruck;

public class TataTruckBuilder extends TruckBuilder {

	public TataTruckBuilder(Integer capacity, String engineType, String fuelType) {
		super(capacity, engineType, fuelType);
	}

	@Override
	protected Truck createTruck() {
		Truck truck = null;

		truck = new TataTruck(capacity, engineType, fuelType);
		return truck;
	}

}
