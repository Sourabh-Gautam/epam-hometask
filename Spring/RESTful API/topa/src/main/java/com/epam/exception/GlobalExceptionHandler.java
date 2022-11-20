package com.epam.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.epam.model.ExceptionDetails;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmptyFieldException.class)
	public ResponseEntity<ExceptionDetails> emptyFieldException(EmptyFieldException ex) {
		ExceptionDetails exceptionDetails = new ExceptionDetails();
		exceptionDetails.setMessage(ex.getLocalizedMessage());
		return ResponseEntity.ok().body(exceptionDetails);
	}
	
	@ExceptionHandler(BlankFieldException.class)
	public ResponseEntity<ExceptionDetails> blankFieldException(BlankFieldException ex) {
		ExceptionDetails exceptionDetails = new ExceptionDetails();
		exceptionDetails.setMessage(ex.getLocalizedMessage());
		return ResponseEntity.ok().body(exceptionDetails);
	}
	
}
