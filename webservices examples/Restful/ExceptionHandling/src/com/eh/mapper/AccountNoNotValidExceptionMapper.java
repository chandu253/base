package com.eh.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.eh.dto.ErrorResponse;
import com.eh.exception.AccountNoNotValidException;

@Provider
public class AccountNoNotValidExceptionMapper implements ExceptionMapper<AccountNoNotValidException> {

	@Override
	public Response toResponse(AccountNoNotValidException e) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode("001");
		errorResponse.setDetails("invalid input data");

		return Response.status(Status.BAD_REQUEST).entity(errorResponse).build();
	}

}
