package org.stackspace.webfaces.exception;

public class WebFacesException extends RuntimeException {

	public WebFacesException(String message, Throwable cause) {
		super(message, cause);
	}

	public WebFacesException(String message) {
		super(message);
	}

}
