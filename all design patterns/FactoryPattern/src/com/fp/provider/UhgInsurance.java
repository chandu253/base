package com.fp.provider;

public class UhgInsurance extends AbstractInsurance {

	public UhgInsurance(int hosptialNo, String hosptialName, String partnerCode) {
		super(hosptialNo, hosptialName, partnerCode);
	}

	@Override
	public void submitAuthorization(String operation, String cardNo) {
		System.out.println("Uhg received authorization from : " + hosptialName + " cardNo : " + cardNo);
	}

}






