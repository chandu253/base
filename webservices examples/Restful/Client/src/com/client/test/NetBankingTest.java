package com.client.test;

import com.client.invoker.Netbanking;

public class NetBankingTest {
	public static void main(String[] args) {
		Netbanking netbanking = new Netbanking();
		/*float balance = netbanking.getBalance("ac1", "ifsc001");
		System.out.println("balance : " + balance);*/
		
		String payees = netbanking.getPayees("ac1", "ifsc002");
		System.out.println(payees);
	}

}
