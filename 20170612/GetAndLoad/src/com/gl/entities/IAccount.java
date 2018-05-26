package com.gl.entities;

public interface IAccount {
	String getAccountNo();

	void setAccountNo(String accountNo);

	String getAccountHolderName();

	void setAccountHolderName(String accountHolderName);

	float getBalance();

	void setBalance(float balance);
}
