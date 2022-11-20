package com.epam.exception;

public class CredentialsMismatchExcpetion extends Exception {

	private static final long serialVersionUID = 1L;

	public CredentialsMismatchExcpetion() {
		super();
	}

	public CredentialsMismatchExcpetion(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CredentialsMismatchExcpetion(String message, Throwable cause) {
		super(message, cause);
	}

	public CredentialsMismatchExcpetion(String message) {
		super(message);
	}

	public CredentialsMismatchExcpetion(Throwable cause) {
		super(cause);
	}

	
}
