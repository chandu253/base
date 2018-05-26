package com.billdesk.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;

@Path("/master")
public class BilldeskMasterProvider implements BilldeskProvider {

	@Override
	public StreamingOutput pay(InputStream in) {
		return new StreamingOutput() {
			@Override
			public void write(OutputStream os) throws IOException, WebApplicationException {
				StringBuilder builder = new StringBuilder();
				builder.append("<master-transaction><tx-no>393</tx-no><status>success</status></master-transaction>");
				os.write(builder.toString().getBytes());
				os.close();
			}
		};
	}

}
