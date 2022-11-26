package com.epam.exception;

public class EmptyFieldException extends Exception {

	private static final long serialVersionUID = 1L;

	public EmptyFieldException() {
		super();
	}

	public EmptyFieldException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmptyFieldException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptyFieldException(String message) {
		super(message);
	}

	public EmptyFieldException(Throwable cause) {
		super(cause);
	}

}
