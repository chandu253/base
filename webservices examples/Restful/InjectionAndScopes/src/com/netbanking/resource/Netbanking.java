package com.netbanking.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/netbaking/{accountNo}/{ifscCode}")
public class Netbanking {
	@PathParam("ifscCode")
	private String ifscCode;
	private String accountNo;

	public Netbanking(@PathParam("accountNo") String accountNo) {
		this.accountNo = accountNo;
		System.out.println("ifscCode : " + ifscCode);
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/balance")
	public float getBalance() {
		return 343.34f;
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/payees")
	public String getPayees() {
		return "<payees><payee>" + accountNo + " - " + ifscCode + "</payee></payees>";
	}
}
