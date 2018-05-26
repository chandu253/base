package com.eh.resource;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.eh.dto.ErrorResponse;
import com.eh.dto.Receipt;
import com.eh.dto.WithdrawlDetails;

@Path("/atm")
public class AtmService {
	@PUT
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Receipt withdrawl(WithdrawlDetails withdrawlDetails) {
		Receipt receipt = null;
		ErrorResponse errorResponse = null;

		if (withdrawlDetails.getAccountNo() == null || withdrawlDetails.getAccountNo().trim().length() == 0) {
			errorResponse = new ErrorResponse();
			errorResponse.setErrorCode("001");
			errorResponse.setDetails("invalid input data");
			throw new WebApplicationException(Response.status(Status.BAD_REQUEST).entity(errorResponse).build());
		}
		receipt = new Receipt();
		receipt.setTxNo(UUID.randomUUID().toString());
		receipt.setAccountNo(withdrawlDetails.getAccountNo());
		receipt.setBalance(withdrawlDetails.getAmount());
		return receipt;
	}
}
