package com.client.invoker;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class MerchantInvoker {
	private final String BASE_URI = "http://localhost:8082/ResteasyBootstrap/api/merchant";

	public String invokeGetMerchantAddress(String merchantName) {
		ClientBuilder builder = null;
		Client client = null;
		WebTarget target = null;
		Response response = null;
		String address = null;

		builder = ClientBuilder.newBuilder();
		builder.property("connection.timeout", 3600);
		client = builder.build();
		target = client.target(BASE_URI);
		target = target.queryParam("merchant-name", merchantName);
		response = target.request().get();
		if (response.getStatus() == 200) {
			address = response.readEntity(String.class);
		}
		return address;
	}
}
