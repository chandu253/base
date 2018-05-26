package com.eh.resource;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.eh.dto.Acknowledge;
import com.eh.exception.AccountNoNotValidException;

@Path("/account")
public class AccountService {
	@PUT
	@Path("/contact/{accNo}/{contactNo}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Acknowledge updatePrimaryContact(@PathParam("accNo") String accountNo,
			@PathParam("contactNo") String contactNo) {
		Acknowledge acknowledge = null;

		if (accountNo == null || accountNo.trim().length() == 0) {
			// will be mapped using exception mapper as we have several places encountering
			// the same error
			throw new AccountNoNotValidException();
		}
		acknowledge = new Acknowledge();
		acknowledge.setAccountNo(accountNo);
		acknowledge.setMessage("contact no updated");
		acknowledge.setStatus("success");

		return acknowledge;
	}
}
