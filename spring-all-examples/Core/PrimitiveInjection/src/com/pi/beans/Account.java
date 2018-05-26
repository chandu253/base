package com.pi.beans;

public class Account {
	private int accountNo;
	private String accountHolderName;

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountHolderName=" + accountHolderName + "]";
	}

}
