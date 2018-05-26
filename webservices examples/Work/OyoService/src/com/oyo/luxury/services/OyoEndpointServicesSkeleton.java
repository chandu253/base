
/**
 * OyoEndpointServicesSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package com.oyo.luxury.services;

import com.oyo.luxury.types.AccomodationFailedFault;
import com.oyo.luxury.types.Receipt;

/**
 * OyoEndpointServicesSkeleton java skeleton for the axisService
 */
public class OyoEndpointServicesSkeleton implements OyoEndpointServicesSkeletonInterface {

	/**
	 * Auto generated method signature
	 * 
	 * @param checkIn0
	 * @return receipt1
	 * @throws AccomodationFault
	 */

	public com.oyo.luxury.types.Receipt bookAccomodation(com.oyo.luxury.types.CheckIn checkIn)
			throws AccomodationFault {
		Receipt receipt = null;
		AccomodationFault fault = null;
		AccomodationFailedFault faultMessage = null;
		if (checkIn.getRoomType().equals("luxury")) {
			faultMessage = new AccomodationFailedFault();
			faultMessage.setErrorType("business");
			faultMessage.setCause("No rooms available");
			faultMessage.setDetail("Please try for another day");
			fault = new AccomodationFault();
			fault.setFaultMessage(faultMessage);
			throw fault;
		}
		receipt = new Receipt();
		receipt.setMessage(checkIn.getRoomType() + " is available and is alloted to : " + checkIn.getPersonName());
		receipt.setEstimatedAmount(3535.34f);
		receipt.setStatus("reserved");
		return receipt;
	}

}
