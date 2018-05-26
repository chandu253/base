package com.eh.exception;

public class AccountNoNotValidException extends RuntimeException {

	public AccountNoNotValidException() {
		super();
	}

	public AccountNoNotValidException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccountNoNotValidException(String message) {
		super(message);
	}

}
