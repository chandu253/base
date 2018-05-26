package com.acc.dto;

public class PlanDto {
	protected int planNo;
	protected String planName;
	protected int validity;
	protected String provider;
	protected float amount;

	public PlanDto(int planNo, String planName, int validity, String provider, float amount) {
		this.planNo = planNo;
		this.planName = planName;
		this.validity = validity;
		this.provider = provider;
		this.amount = amount;
	}

	public int getPlanNo() {
		return planNo;
	}

	public void setPlanNo(int planNo) {
		this.planNo = planNo;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

}
