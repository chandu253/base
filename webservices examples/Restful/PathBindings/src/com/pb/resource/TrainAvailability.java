package com.pb.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/availability")
public class TrainAvailability {
	@Path("/trains/{src}/{dest}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String getTrains(@PathParam("src") String source, @PathParam("dest") String destination) {
		return "<trains><train><train-name>" + source + destination + "</train-name></train></trains>";
	}

	@Path("/seats/{trainNo}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String getSeats(@PathParam("trainNo") int trainNo) {
		return "<seats>" + trainNo + "</seats>";
	}
}
