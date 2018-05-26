package com.client.invoker;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;

public class Agent {
	private final String AGENT_URI = "http://localhost:8082/MagicBricks/api/agent/{loc}";

	public String search(String location, String propertyType, String area, int sqYards, int minBudget, int maxBudget) {
		Response response = null;
		String result = null;

		WebTarget target = ClientBuilder.newClient().target(AGENT_URI).resolveTemplate("loc", location).path("search")
				.path(propertyType).matrixParam("sqYards", sqYards).path(area).matrixParam("minBudget", minBudget)
				.matrixParam("maxBudget", maxBudget);
		System.out.println(target.getUri().toString());
		response = target.request().get();

		System.out.println(response.getStatus());
		if (response.getStatus() == 200) {
			response.bufferEntity();
			result = response.readEntity(String.class);
		}

		return result;
	}

	public String unlistProperty(String location, String propertyNo, String agentNo) {
		Response response = null;
		String message = null;

		response = ClientBuilder.newClient().target(AGENT_URI).resolveTemplate("loc", location).path("/unlist")
				.path(propertyNo).request().header("agentNo", agentNo).delete();
		if (response.getStatus() == 200) {
			message = response.readEntity(String.class);
		}
		return message;
	}

	public String addAmenity(String location, String amentityName, String propertyNo) {
		Response response = null;
		String message = null;

		response = ClientBuilder.newClient().target(AGENT_URI).resolveTemplate("loc", location).path("/amenity")
				.path(amentityName).request().cookie(new Cookie("propertyNo", propertyNo)).put(Entity.text(""));

		if (response.getStatus() == 200) {
			message = response.readEntity(String.class);
		}
		return message;
	}
}
