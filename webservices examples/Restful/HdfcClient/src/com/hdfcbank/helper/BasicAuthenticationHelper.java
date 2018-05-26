package com.hdfcbank.helper;

import org.glassfish.jersey.internal.util.Base64;

public class BasicAuthenticationHelper {
	public static String getBasicAuthorization(String userName, String password) {
		String authorizationToken = null;
		String token = null;
		
		token = userName +":"+password;
		authorizationToken = "Basic " + Base64.encodeAsString(token.getBytes());
		
		return authorizationToken;
	}
	
	public static void main(String[] args) {
		BasicAuthenticationHelper.getBasicAuthorization("mathew", "welcome1");
	}
}









