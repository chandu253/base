package com.netbanking.dao.qe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipersist.executor.QueryExecutor;
import com.netbanking.bo.Account;

public class AccountsQueryExecutor extends QueryExecutor {

	@Override
	protected Object handle(ResultSet rs) throws SQLException {
		List<Account> accounts = null;
		Account account = null;
		accounts = new ArrayList<>();
		
		while (rs.next()) {
			account = new Account();
			account.setAccountNo(rs.getString("account_no"));
			account.setAccountHolderName(rs.getString("account_holder_nm"));
			account.setBalance(rs.getDouble("balance"));

			accounts.add(account);
		}

		return accounts;
	}

}
