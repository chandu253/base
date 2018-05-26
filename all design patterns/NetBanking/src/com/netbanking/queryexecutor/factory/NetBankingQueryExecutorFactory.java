package com.netbanking.queryexecutor.factory;

import com.ipersist.executor.QueryExecutor;
import com.ipersist.executor.factory.AbstractQueryExecutorFactory;
import com.netbanking.dao.qe.AccountsQueryExecutor;

public class NetBankingQueryExecutorFactory extends AbstractQueryExecutorFactory {
	@Override
	protected QueryExecutor createQueryExecutor(String type) {
		QueryExecutor queryExecutor = null;

		if (type.equals("accounts")) {
			queryExecutor = new AccountsQueryExecutor();
		}
		return queryExecutor;
	}
}
