package com.templatemethod.dto;

import java.util.Date;

public class LoanInfo {
	protected String loanNo;
	protected String loanType;
	protected float amount;
	protected Date loanIssuedDate;

	public String getLoanNo() {
		return loanNo;
	}

	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getLoanIssuedDate() {
		return loanIssuedDate;
	}

	public void setLoanIssuedDate(Date loanIssuedDate) {
		this.loanIssuedDate = loanIssuedDate;
	}

}
