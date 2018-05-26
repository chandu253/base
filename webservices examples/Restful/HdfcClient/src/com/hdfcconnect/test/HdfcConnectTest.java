package com.hdfcconnect.test;

import com.hdfcconnect.dto.Account;
import com.hdfcconnect.endpoint.AccountEndpoint;

public class HdfcConnectTest {
	public static void main(String[] args) {
		AccountEndpoint accountEndpoint = null;
		Account account = null;

		accountEndpoint = new AccountEndpoint();
		account = accountEndpoint.getAccount("ac1", "mathew", "welcome1");
		System.out.println("accountHolderName : " + account.getAccountHolderName());

	}
}
