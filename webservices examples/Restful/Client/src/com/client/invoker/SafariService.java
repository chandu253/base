package com.client.invoker;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

public class SafariService {
	private final String SAFARI_URI = "http://localhost:8081/ContentHandler/api/safari";

	public String addBook(String isbn, String title, String author) {
		Response response = null;
		Form formData = null;
		String message = null;

		formData = new Form();
		formData.param("isbn", isbn);
		formData.param("title", title);
		formData.param("author", author);

		response = ClientBuilder.newClient().target(SAFARI_URI).path("/book").path("/form").request()
				.post(Entity.form(formData));
		if (response.getStatus() == 200) {
			response.bufferEntity();
			message = response.readEntity(String.class);
		}
		return message;
	}
}
