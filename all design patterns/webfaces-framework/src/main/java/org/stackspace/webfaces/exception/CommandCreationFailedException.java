package org.stackspace.webfaces.exception;

public class CommandCreationFailedException extends WebFacesException {

	public CommandCreationFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommandCreationFailedException(String message) {
		super(message);
	}

}
