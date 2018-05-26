package com.jsp.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

@Path("/product")
@Api
public class Product {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{productNo}")
	@ApiOperation(nickname = "getProductName", produces = "text/plain", value = "getProductName")
	@ApiResponse(message = "productName", code = 200)
	public String getProductName(
			@ApiParam(name = "productNo", required = true) @PathParam("productNo") String productNo) {
		return "Television";
	}

}
