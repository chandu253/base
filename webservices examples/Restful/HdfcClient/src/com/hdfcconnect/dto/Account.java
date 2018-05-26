package com.hdfcconnect.dto;

public class Account {
	protected String accountNo;
	protected String accountHolderName;
	protected String accountType;
	protected String branch;
	protected String registeredMobileNumber;
	protected String emailAddress;
	protected float balance;

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getRegisteredMobileNumber() {
		return registeredMobileNumber;
	}

	public void setRegisteredMobileNumber(String registeredMobileNumber) {
		this.registeredMobileNumber = registeredMobileNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

}
