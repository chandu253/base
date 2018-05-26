package com.client.invoker;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class Netbanking {
	private final String NET_BANKING_URI = "http://localhost:8081/InjectionAndScopes/secure/netbaking/{accountNo}/{ifscCode}";

	public float getBalance(String accountNo, String ifscCode) {
		ClientBuilder builder = null;
		Client client = null;
		WebTarget target = null;
		Response response = null;
		float balance = 0.0f;

		builder = ClientBuilder.newBuilder();
		client = builder.build();
		target = client.target(NET_BANKING_URI).path("/balance");
		target = target.resolveTemplate("accountNo", accountNo);
		target = target.resolveTemplate("ifscCode", ifscCode);
		System.out.println(target.getUri().toString());
		response = target.request().get();
		if (response.getStatus() == 200) {
			balance = response.readEntity(Float.class);
		}

		return balance;
	}

	public String getPayees(String accountNo, String ifscCode) {
		return ClientBuilder.newClient().target(NET_BANKING_URI).path("/payees").resolveTemplate("accountNo", accountNo)
				.resolveTemplate("ifscCode", ifscCode).request().get(String.class);
	}

}
