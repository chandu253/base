package com.msf.test;

import java.util.Date;

import com.msf.dao.VehicleDao;
import com.msf.entities.Vehicle;
import com.msf.helper.SessionFactoryRegistry;

public class MSFTest {
	public static void main(String[] args) {
		try {
			VehicleDao vehicleDao = new VehicleDao();
			Vehicle vehicle = new Vehicle();
			vehicle.setVehicleNo(35);
			vehicle.setVehicleModelName("Honda City");
			vehicle.setPurchaseDate(new Date());
			vehicle.setRegistrationNo("TS 09 AK 2938");
			vehicle.setColor("Red");
			vehicle.setEngineNo("e948955");
			vehicle.setChasisNo("c35393");
			vehicle.setBatteryNo("b30384");

			vehicleDao.saveVehicle(vehicle);
			System.out.println("vehicle stored");
		} finally {
			SessionFactoryRegistry.closeSessionFactory();
		}
	}
}
