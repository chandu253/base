package com.ac.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cab")
public class Cab {
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/request/{source}/{destination}")
	public void requestCab(@PathParam("source") final String source, @PathParam("destination") final String destination,
			@Suspended AsyncResponse asyncResponse) {
		new Thread() {
			@Override
			public void run() {
				Response response = null;

				response = Response.ok(source + destination).build();
				asyncResponse.resume(response);
			}
		}.start();
	}
}
