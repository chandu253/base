package com.sr.resource;

import java.util.Random;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.Produces;

import com.sr.dto.Account;
import com.sr.dto.Application;

@Path("/account")
public class AccountService {
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createAccount(Application application) {
		Account account = new Account();

		account.setAccountNo(UUID.randomUUID().toString());
		account.setAccountHolderName(application.getAccountHolderName());
		account.setBalance(application.getMinBalance());

		return Response.status(201).entity(account).header("header1", "no-header")
				.cookie(new NewCookie("mycookie", "cookievalue")).build();
	}
}









