package com.resteasybootstrap.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/merchant")
public class MerchantResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMerchantAddress(@QueryParam("merchant-name") String merchantName) {
		return "merchant Name : " + merchantName + "  address : s.r nagar";
	}
}
