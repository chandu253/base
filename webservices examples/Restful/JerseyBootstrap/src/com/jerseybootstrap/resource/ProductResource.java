package com.jerseybootstrap.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/product")
public class ProductResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public int getProductPrice(@QueryParam("product-code") String productCode) {
		return this.hashCode();
	}
}




