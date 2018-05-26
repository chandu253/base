package com.builder.test;

import com.builder.api.Truck;

public class BuilderTest {
	public static void main(String[] args) {
		System.setProperty("com.builder.api.builder.class", "com.builder.benz.builder.BenzTruckBuilder");
		Truck truck = Truck.newTruckBuilder(10, "power", "diesel").truckType("heavy").tyres(10).mileage(25).build();
		System.out.println(truck);
	}
}
