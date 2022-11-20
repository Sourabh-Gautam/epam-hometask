package com.epam.exception;

public class BlankFieldException extends Exception {

	private static final long serialVersionUID = 1L;

	public BlankFieldException() {
		super();
	}

	public BlankFieldException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BlankFieldException(String message, Throwable cause) {
		super(message, cause);
	}

	public BlankFieldException(String message) {
		super(message);
	}

	public BlankFieldException(Throwable cause) {
		super(cause);
	}

	
	
}
