package com.epam.model;

public class ExceptionDetails {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ExceptionDetails(String message) {
		super();
		this.message = message;
	}

	public ExceptionDetails() {
		super();
	}
	
	
	
}
