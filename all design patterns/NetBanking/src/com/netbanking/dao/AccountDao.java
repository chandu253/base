package com.netbanking.dao;

import java.util.List;

import com.ipersist.executor.factory.AbstractQueryExecutorFactory;
import com.netbanking.bo.Account;
import com.netbanking.dao.qe.AccountsQueryExecutor;
import com.netbanking.queryexecutor.factory.NetBankingQueryExecutorFactory;

public class AccountDao {
	public List<Account> getAccounts() {
		AccountsQueryExecutor accountsQueryExecutor = null;
		AbstractQueryExecutorFactory executorFactory = null;

		executorFactory = new NetBankingQueryExecutorFactory();
		accountsQueryExecutor = (AccountsQueryExecutor) executorFactory.newQueryExecutor("accounts",
				"com/netbanking/dao/qe/accounts-qe.xml");
		return (List<Account>) accountsQueryExecutor.execute();
	}
}
