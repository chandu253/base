package com.cw.resource;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.cw.dto.OrderStatus;

@Path("/amazontransport")
public class AmazonTransportService {
	private Map<String, OrderStatus> orderMap;

	public AmazonTransportService() {
		orderMap = new HashMap<>();
		OrderStatus os = new OrderStatus();
		os.setOrderNo("o1");
		os.setStatus("Accepted");
		os.setMessage("Ordered Approved");

		orderMap.put("o1", os);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{orderNo}")
	public Response track(@PathParam("orderNo") String orderNo, @Context Request request) {
		CacheControl cacheControl = null;
		OrderStatus oStatus = null;
		String eTag = null;
		ResponseBuilder builder = null;

		// fetch data from database
		oStatus = orderMap.get(orderNo);
		eTag = String.valueOf(oStatus.hashCode());
		// if client ETag matches with server ETag, it returns builder
		// status = redirect
		builder = request.evaluatePreconditions(new EntityTag(eTag));
		if (builder != null) {
			return builder.cacheControl(cacheControl).build();
		}

		cacheControl = new CacheControl();
		cacheControl.setMaxAge(1000 * 60);
		cacheControl.setMustRevalidate(true);

		System.out.println("track()");
		return Response.ok(oStatus).cacheControl(cacheControl).tag(new EntityTag(eTag)).build();
	}

	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{orderNo}/{status}")
	public String changeOrderStatus(@PathParam("orderNo") String orderNo, @PathParam("status") String status) {
		OrderStatus os = null;

		os = orderMap.get(orderNo);
		os.setStatus(status);
		orderMap.put(orderNo, os);
		return "your order has been updated";
	}
}
