package com.srl.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

public class HomeApplianceCare {
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/refrigerators")
	public String getRefrigerators(@QueryParam("type") String type) {
		return "<refrigerators>" + type + "</refrigerators>";
	}

}
