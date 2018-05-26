package com.hdfcconnect.endpoint;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.hdfcbank.helper.BasicAuthenticationHelper;
import com.hdfcconnect.dto.Account;
import com.hdfcconnect.filter.BasicAuthenticationFilter;

public class AccountEndpoint {
	protected final String ACCOUNT_URI = "http://localhost:8082/HdfcBank/api/account";

	public Account getAccount(String accountNo, String userName, String password) {
		Client client = null;
		Account account = null;
		BasicAuthenticationFilter basicAuthenticationFilter = null;

		try {
			client = ClientBuilder.newClient();
			basicAuthenticationFilter = new BasicAuthenticationFilter(userName, password);
			client.register(basicAuthenticationFilter);

			account = client.target(ACCOUNT_URI).path(accountNo).request().accept(MediaType.APPLICATION_JSON)
					.get(Account.class);
		} catch (ForbiddenException | NotAuthorizedException e) {
			e.printStackTrace();
			throw e;
		}
		return account;
	}

	public String changeRegisteredMobileNumber(String accountNo, String mobileNumber, String userName,
			String password) {
		String message = null;

		try {
			message = ClientBuilder.newClient().target(ACCOUNT_URI).path(accountNo).path(mobileNumber).request()
					.put(Entity.text(""), String.class);
		} catch (ForbiddenException | NotAuthorizedException e) {
			e.printStackTrace();
			throw e;
		}

		return message;
	}
}
