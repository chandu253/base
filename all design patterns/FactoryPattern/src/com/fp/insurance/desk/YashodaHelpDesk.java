package com.fp.insurance.desk;

import com.fp.insurance.desk.factory.InsuranceFactory;
import com.fp.provider.Insurance;

public class YashodaHelpDesk {
	public void preApproval(String provider, String operation, String healthCardNo) {
		Insurance insurance = null;

		insurance = InsuranceFactory.newInsurance(provider);
		insurance.submitAuthorization(operation, healthCardNo);
	}
}
