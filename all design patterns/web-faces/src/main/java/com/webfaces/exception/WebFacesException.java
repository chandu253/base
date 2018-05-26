package com.webfaces.exception;

public class WebFacesException extends RuntimeException {

	public WebFacesException() {
		super();
	}

	public WebFacesException(String message, Throwable cause) {
		super(message, cause);
	}

	public WebFacesException(String message) {
		super(message);
	}

}
