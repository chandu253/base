package com.hdfcbank.resource;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import com.hdfcbank.dto.Account;

@Path("/account")
public class AccountService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{accountNo}")
	@RolesAllowed({ "user", "clerk" })
	public Account getAccount(@PathParam("accountNo") String accountNo, @Context SecurityContext securityContext) {
		Account account = null;

		// logged in user role
		if (securityContext.isUserInRole("user")) {
			String userName = securityContext.getUserPrincipal().getName();
			// check the accountNo requested belongs to userName
			if (userName.equals("mathew") && accountNo.equals("ac1") == false) {
				throw new ForbiddenException("you are not account owner to access");
			}
		}

		account = new Account();
		account.setAccountNo(accountNo);
		account.setAccountHolderName("Mathew");
		account.setAccountType("Savings");
		account.setBranch("Ameerpet");
		account.setRegisteredMobileNumber("123456789");
		account.setEmailAddress("mathew@gmail.com");
		account.setBalance(353.34f);

		return account;
	}

	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{accountNo}/{mobileNumber}")
	@RolesAllowed("clerk")
	public String changeRegisteredMobileNumber(@PathParam("accountNo") String accountNo,
			@PathParam("mobileNumber") String mobileNumber) {
		return "Your account " + accountNo + " has been updated with registered mobile number as : " + mobileNumber;
	}
}
