package com.hdfcconnect.filter;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.MultivaluedMap;

import com.hdfcbank.helper.BasicAuthenticationHelper;

public class BasicAuthenticationFilter implements ClientRequestFilter {
	protected String userName;
	protected String password;

	public BasicAuthenticationFilter(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	@Override
	public void filter(ClientRequestContext requestContext) throws IOException {
		MultivaluedMap<String, Object> httpHeaders = null;
		String authorizationToken = null;

		httpHeaders = requestContext.getHeaders();
		authorizationToken = BasicAuthenticationHelper.getBasicAuthorization(userName, password);
		httpHeaders.add("authorization", authorizationToken);

	}

}
