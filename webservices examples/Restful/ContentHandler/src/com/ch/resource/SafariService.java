package com.ch.resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.StreamingOutput;

@Path("/safari")
public class SafariService {
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/book")
	public String addBook(InputStream in) throws IOException {
		int c;
		StringBuffer buffer = null;

		try {
			buffer = new StringBuffer();
			while ((c = in.read()) != -1) {
				buffer.append((char) c);
			}
		} finally {
			in.close();
		}
		return buffer.toString();
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	@Path("/author")
	public String addAuthor(Reader reader) throws IOException {
		StringBuffer buffer = null;
		int c = 0;

		buffer = new StringBuffer();
		try {
			while ((c = reader.read()) != -1) {
				buffer.append((char) c);
			}
		} finally {
			reader.close();
		}
		return buffer.toString();
	}

	@PUT
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/chapter/{isbn}/{chapterNo}")
	public byte[] updateChapter(@PathParam("isbn") String isbn, @PathParam("chapterNo") String chapterNo,
			byte[] content) {
		StringBuffer buffer = null;

		buffer = new StringBuffer();
		for (byte b : content) {
			buffer.append((char) b);
		}
		buffer.append(", isbn").append(isbn).append(", chapterNo : ").append(chapterNo);
		return buffer.toString().getBytes();
	}

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/book/attach/{title}/{author}")
	public StreamingOutput uploadBook(@PathParam("title") String title, @QueryParam("description") String description,
			@PathParam("author") String author, File bookFile) throws IOException {
		StringBuffer buffer = null;
		InputStream in = null;
		int c = 0;

		try {
			buffer = new StringBuffer();
			in = new FileInputStream(bookFile);
			while ((c = in.read()) != -1) {
				buffer.append((char) c);
			}
		} finally {
			in.close();
		}
		buffer.append(", title :").append(title).append(" description : ").append(description).append(" , author : ")
				.append(author);
		return new BookStreamingOutput(buffer.toString());
	}

	private final class BookStreamingOutput implements StreamingOutput {
		private String content;

		public BookStreamingOutput(String content) {
			this.content = content;
		}

		@Override
		public void write(OutputStream os) throws IOException, WebApplicationException {
			os.write(content.getBytes());
			os.close();
		}

	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/review")
	public String reviewBook(String review) {
		return review;
	}

	@GET
	@Produces(MediaType.MULTIPART_FORM_DATA)
	@Path("/book/{isbn}")
	public File dowloadBook(@PathParam("isbn") String isbn) {
		return new File("C:\\apache-ant-1.9.4\\README");
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/book/form")
	public String addBook(MultivaluedMap<String, String> formData) {
		StringBuffer buffer = new StringBuffer();

		for (String param : formData.keySet()) {
			buffer.append(param).append(" : ").append(formData.get(param));
		}
		return buffer.toString();
	}

}
