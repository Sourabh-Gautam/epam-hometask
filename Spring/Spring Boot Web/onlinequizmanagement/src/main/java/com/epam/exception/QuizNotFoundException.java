package com.epam.exception;

public class QuizNotFoundException extends Exception {

	public QuizNotFoundException() {
		super();
	}

	public QuizNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public QuizNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public QuizNotFoundException(String message) {
		super(message);
	}

	public QuizNotFoundException(Throwable cause) {
		super(cause);
	}

}