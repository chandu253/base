package com.builder.api.builder;

import com.builder.api.Truck;

public abstract class TruckBuilder {
	protected String truckType;
	protected int capacity;
	protected String engineType;
	protected String fuelType;
	protected int tyres;
	protected int mileage;

	public TruckBuilder(Integer capacity, String engineType, String fuelType) {
		this.capacity = capacity;
		this.engineType = engineType;
		this.fuelType = fuelType;
	}

	public TruckBuilder truckType(String truckType) {
		this.truckType = truckType;
		return this;
	}

	public TruckBuilder capacity(int capacity) {
		this.capacity = capacity;
		return this;
	}

	public TruckBuilder engineType(String engineType) {
		this.engineType = engineType;
		return this;
	}

	public TruckBuilder fuelType(String fuelType) {
		this.fuelType = fuelType;
		return this;
	}

	public TruckBuilder tyres(int tyres) {
		this.tyres = tyres;
		return this;
	}

	public TruckBuilder mileage(int mileage) {
		this.mileage = mileage;
		return this;
	}

	// builds the abstract component implementation object with data
	public Truck build() {
		Truck truck = null;

		truck = createTruck();
		truck.setTruckType(truckType);
		truck.setTyres(tyres);
		truck.setMileage(mileage);
		return truck;
	}

	protected abstract Truck createTruck();

}
