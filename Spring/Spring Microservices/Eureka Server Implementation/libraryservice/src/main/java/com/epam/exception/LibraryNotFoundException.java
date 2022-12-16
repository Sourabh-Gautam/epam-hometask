package com.epam.exception;

public class LibraryNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public LibraryNotFoundException() {
		super();
	}

	public LibraryNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public LibraryNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public LibraryNotFoundException(String message) {
		super(message);
	}

	public LibraryNotFoundException(Throwable cause) {
		super(cause);
	}

}
