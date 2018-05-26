package com.fp.provider;

public abstract class AbstractInsurance implements Insurance {
	protected int hosptialNo;
	protected String hosptialName;
	protected String partnerCode;

	public AbstractInsurance(int hosptialNo, String hosptialName, String partnerCode) {
		this.hosptialNo = hosptialNo;
		this.hosptialName = hosptialName;
		this.partnerCode = partnerCode;
	}

	public int getHosptialNo() {
		return hosptialNo;
	}

	public void setHosptialNo(int hosptialNo) {
		this.hosptialNo = hosptialNo;
	}

	public String getHosptialName() {
		return hosptialName;
	}

	public void setHosptialName(String hosptialName) {
		this.hosptialName = hosptialName;
	}

	public String getPartnerCode() {
		return partnerCode;
	}

	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}

}
