package com.il.bo;

import java.util.Date;

public class Loan {
	protected int loanNo;
	protected int loanApplicationNo;
	protected String applicantName;
	protected String loanType;
	protected double issuedLoanAmount;
	protected Date loanIssuedDate;
	protected String status;

	public int getLoanNo() {
		return loanNo;
	}

	public void setLoanNo(int loanNo) {
		this.loanNo = loanNo;
	}

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

	public double getIssuedLoanAmount() {
		return issuedLoanAmount;
	}

	public void setIssuedLoanAmount(double issuedLoanAmount) {
		this.issuedLoanAmount = issuedLoanAmount;
	}

	public Date getLoanIssuedDate() {
		return loanIssuedDate;
	}

	public void setLoanIssuedDate(Date loanIssuedDate) {
		this.loanIssuedDate = loanIssuedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
