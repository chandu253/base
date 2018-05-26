package com.cch.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cch.dto.Acknowledge;
import com.cch.dto.Book;

@Path("/safari")
public class SafariService {
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Acknowledge addBook(Book book) {
		Acknowledge ack = new Acknowledge();
		ack.setReqNo(book.getIsbn());
		ack.setMessage("Your " + book.getTitle() + " is under review...");
		ack.setStatus("review");

		return ack;
	}
}
