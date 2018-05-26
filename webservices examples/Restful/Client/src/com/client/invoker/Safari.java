package com.client.invoker;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.client.dto.Acknowledge;
import com.client.dto.Book;

public class Safari {
	private final String SAFARI_URI = "http://localhost:8082/CustomContentHandler/api/safari";

	public Acknowledge addBook(Book book) {
		Response response = null;
		Acknowledge ack = null;
		String ackMessage = null;

		response = ClientBuilder.newClient().target(SAFARI_URI).request().accept(MediaType.APPLICATION_XML)
				.post(Entity.xml(book));
		
		if (response.getStatus() == 200) {
			response.bufferEntity();
			ackMessage = response.readEntity(String.class);
			System.out.println(ackMessage);
			ack = response.readEntity(Acknowledge.class);
		}

		return ack;
	}
}
