package com.billdesk.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;

@Path("/visa")
public class BilldeskVisaProvider implements BilldeskProvider {
	@Override
	public StreamingOutput pay(InputStream in) {
		return new StreamingOutput() {
			@Override
			public void write(OutputStream os) throws IOException, WebApplicationException {
				StringBuilder builder = new StringBuilder();
				builder.append("<visa-transaction><tx-no>393</tx-no><status>success</status></visa-transaction>");
				os.write(builder.toString().getBytes());
				os.close();
			}
		};
	}
}
