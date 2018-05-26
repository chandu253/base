package com.il.dto;

import java.io.Serializable;

public class LoanDetails implements Serializable {
	protected int loanNo;
	protected String applicantName;
	protected String loanType;
	protected double issuedLoanAmount;
	protected String status;

	public int getLoanNo() {
		return loanNo;
	}

	public void setLoanNo(int loanNo) {
		this.loanNo = loanNo;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public double getIssuedLoanAmount() {
		return issuedLoanAmount;
	}

	public void setIssuedLoanAmount(double issuedLoanAmount) {
		this.issuedLoanAmount = issuedLoanAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
