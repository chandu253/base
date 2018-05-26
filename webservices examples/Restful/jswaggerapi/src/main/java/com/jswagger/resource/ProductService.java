package com.jswagger.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/product")
@Api
public class ProductService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{productNo}")
	@ApiOperation(notes = "provides product price", httpMethod = "GET", produces = "text/plain", response = Float.class, value = "getProductPrice")
	@ApiResponses({ @ApiResponse(code = 200, message = "product price") })
	public float getProductPrice(
			@ApiParam(name = "productNo", required = true) @PathParam("productNo") String productNo) {
		return 353.34f;
	}
}






