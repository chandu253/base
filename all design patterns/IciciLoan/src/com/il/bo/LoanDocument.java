package com.il.bo;

public class LoanDocument {
	protected int loanApplicationNo;
	protected String applicantName;
	protected String loanType;
	protected double loanAmount;
	protected int tenure;

	public int getLoanApplicationNo() {
		return loanApplicationNo;
	}

	public void setLoanApplicationNo(int loanApplicationNo) {
		this.loanApplicationNo = loanApplicationNo;
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

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

}
