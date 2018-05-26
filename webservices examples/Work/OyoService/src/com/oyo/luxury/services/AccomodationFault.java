
/**
 * AccomodationFault.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.oyo.luxury.services;

public class AccomodationFault extends java.lang.Exception {

	private static final long serialVersionUID = 1511364997472L;

	private com.oyo.luxury.types.AccomodationFailedFault faultMessage;

	public AccomodationFault() {
		super("AccomodationFault");
	}

	public AccomodationFault(java.lang.String s) {
		super(s);
	}

	public AccomodationFault(java.lang.String s, java.lang.Throwable ex) {
		super(s, ex);
	}

	public AccomodationFault(java.lang.Throwable cause) {
		super(cause);
	}

	public void setFaultMessage(com.oyo.luxury.types.AccomodationFailedFault msg) {
		faultMessage = msg;
	}

	public com.oyo.luxury.types.AccomodationFailedFault getFaultMessage() {
		return faultMessage;
	}
}
