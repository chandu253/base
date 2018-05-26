package com.magicbricks.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.magicbricks.bean.ProductCode;

@Path("/product")
public class ProductResource {
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/{productCode}")
	public String getProduct(@PathParam("productCode") ProductCode productCode) {
		return "<product><category>" + productCode.getCategory() + "</category><productNo>" + productCode.getProductNo()
				+ "</productNo></product>";
	}
}
