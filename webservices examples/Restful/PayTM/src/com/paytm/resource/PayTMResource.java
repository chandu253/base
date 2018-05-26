package com.paytm.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/api")
public class PayTMResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public float balance(@QueryParam("mobile") String mobile) {
		// goto database and fetch the balance for the wallet mobile
		return 35.3f;
	}
}
