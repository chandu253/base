package com.pagination.execption;

public class PaginationException extends RuntimeException {

	public PaginationException() {
		super();
	}

	public PaginationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PaginationException(String message, Throwable cause) {
		super(message, cause);
	}

	public PaginationException(String message) {
		super(message);
	}

	public PaginationException(Throwable cause) {
		super(cause);
	}

}
