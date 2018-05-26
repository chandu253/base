package com.ac.dto;

public class Plan {
	protected String planName;
	protected int validity;
	protected float amount;

	public Plan(String planName, int validity, float amount) {
		super();
		this.planName = planName;
		this.validity = validity;
		this.amount = amount;
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

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

}
