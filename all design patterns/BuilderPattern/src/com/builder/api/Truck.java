package com.builder.api;

import java.lang.reflect.Constructor;

import com.builder.api.builder.TruckBuilder;
import com.builder.api.exception.UnknownProviderException;

// api
public abstract class Truck {
	protected String truckType;
	protected int capacity;
	protected String engineType;
	protected String fuelType;
	protected int tyres;
	protected int mileage;

	public Truck(int capacity, String engineType, String fuelType) {
		this.capacity = capacity;
		this.engineType = engineType;
		this.fuelType = fuelType;
	}

	protected abstract int accelerate(int speed);

	public static TruckBuilder newTruckBuilder(int capacity, String engineType, String fuelType) {
		Class builderClazz = null;
		String builderClassName = null;
		TruckBuilder truckBuilder = null;
		Constructor<?> builderClazzConstructor = null;

		try {
			builderClassName = System.getProperty("com.builder.api.builder.class");
			builderClazz = Class.forName(builderClassName);
			builderClazzConstructor = builderClazz.getDeclaredConstructor(Integer.class, String.class, String.class);
			truckBuilder = (TruckBuilder) builderClazzConstructor.newInstance(capacity, engineType, fuelType);

		} catch (Exception e) {
			throw new UnknownProviderException("unable to instantiate implementation builder", e);
		}
		return truckBuilder;
	}

	public String getTruckType() {
		return truckType;
	}

	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getTyres() {
		return tyres;
	}

	public void setTyres(int tyres) {
		this.tyres = tyres;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	@Override
	public String toString() {
		return "Truck [truckType=" + truckType + ", capacity=" + capacity + ", engineType=" + engineType + ", fuelType="
				+ fuelType + ", tyres=" + tyres + ", mileage=" + mileage + "]";
	}

}
