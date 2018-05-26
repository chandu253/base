package com.srl.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class MobileCare {
	@PathParam("jobNo")
	private String jobNo;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/repair/{jobNo}")
	public String getRepairStatus() {
		return "jobNo : " + jobNo + " is under progress : " + this.hashCode();
	}
}
