package com.oyo.test;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import com.oyo.luxury.services.AccomodationFault;
import com.oyo.luxury.services.OyoEndpointServicesStub;
import com.oyo.luxury.types.CheckIn;
import com.oyo.luxury.types.Receipt;

public class OyoTest {
	public static void main(String[] args) throws AxisFault {
		OyoEndpointServicesStub stub = new OyoEndpointServicesStub();
		CheckIn ci = new CheckIn();
		ci.setNoOfDays(5);
		ci.setPersonName("john");
		ci.setRoomType("luxury");
		try {
			Receipt receipt = stub.bookAccomodation(ci);
			System.out.println("amount : " + receipt.getEstimatedAmount());
		} catch (RemoteException | AccomodationFault e) {
			e.printStackTrace();
		}
		
	}
}






