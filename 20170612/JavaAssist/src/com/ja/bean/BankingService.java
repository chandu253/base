package com.ja.bean;

public class BankingService implements IBankingService {

	@Override
	public double getBalance(String accountNo) {
		System.out.println("BankingService.getBalance(" + accountNo + ")");
		return 100;
	}

}
