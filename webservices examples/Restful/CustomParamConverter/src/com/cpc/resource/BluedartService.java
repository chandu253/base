package com.cpc.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cpc.dto.AwbNo;

@Path("/bluedart")
public class BluedartService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/track/{awbNo}")
	public String getCourierStatus(@PathParam("awbNo") AwbNo awbNo) {
		return "awbNo : " + awbNo.getBranch() + "" + awbNo.getRefNo() + " is in transit";
	}
}











