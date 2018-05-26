package com.fp.provider;

public class AthenaInsurance extends AbstractInsurance {

	public AthenaInsurance(int hosptialNo, String hosptialName, String partnerCode) {
		super(hosptialNo, hosptialName, partnerCode);
	}

	@Override
	public void submitAuthorization(String operation, String cardNo) {
		System.out.println("Athena received authorization from : " + hosptialName + " cardNo : " + cardNo);
	}

}
