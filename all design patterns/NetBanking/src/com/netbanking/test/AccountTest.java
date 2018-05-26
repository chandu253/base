package com.netbanking.test;

import java.util.List;

import com.netbanking.bo.Account;
import com.netbanking.dao.AccountDao;

public class AccountTest {
	public static void main(String[] args) {
		AccountDao accountDao = new AccountDao();
		List<Account> accounts = accountDao.getAccounts();

		for (Account account : accounts) {
			System.out.println("accountHolderName : " + account.getAccountHolderName());
		}
	}
}
