package com.epam.exception;

public class NoSuchFieldException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoSuchFieldException() {
		super();
	}

	public NoSuchFieldException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoSuchFieldException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchFieldException(String message) {
		super(message);
	}

	public NoSuchFieldException(Throwable cause) {
		super(cause);
	}

	
	
}
