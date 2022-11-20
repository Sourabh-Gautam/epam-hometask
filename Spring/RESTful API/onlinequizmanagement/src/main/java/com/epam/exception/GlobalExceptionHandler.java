package com.epam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.epam.dto.ExceptionDetails;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ExceptionDetails> resourceNotFoundException(ResourceNotFoundException e) {
	    ExceptionDetails exceptionDetails = new ExceptionDetails(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
	    return new ResponseEntity<>(exceptionDetails, exceptionDetails.getHttpStatus());
	}
	
	@ExceptionHandler(EmptyFieldException.class)
	public ResponseEntity<ExceptionDetails> emptyFieldException(EmptyFieldException e) {
		ExceptionDetails exceptionDetails = new ExceptionDetails(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
		return new ResponseEntity<>(exceptionDetails, exceptionDetails.getHttpStatus());
	}
	
	@ExceptionHandler(NoSuchFieldException.class)
	public ResponseEntity<ExceptionDetails> noSuchFieldException(NoSuchFieldException e) {
		ExceptionDetails exceptionDetails = new ExceptionDetails(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
		return new ResponseEntity<>(exceptionDetails, exceptionDetails.getHttpStatus());
	}
	
	@ExceptionHandler(CredentialsMismatchExcpetion.class)
	public ResponseEntity<ExceptionDetails> noSuchFieldException(CredentialsMismatchExcpetion e) {
		ExceptionDetails exceptionDetails = new ExceptionDetails(HttpStatus.EXPECTATION_FAILED, e.getLocalizedMessage());
		return new ResponseEntity<>(exceptionDetails, exceptionDetails.getHttpStatus());
	}
	
}
