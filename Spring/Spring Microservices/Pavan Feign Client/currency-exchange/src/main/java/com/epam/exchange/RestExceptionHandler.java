package com.epam.exchange;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> handleException(Exception e) {
		
		Map<String, String> response = new HashMap<>();
		response.put("timestamp", new Date().toString());
		response.put("error", e.getMessage());
		response.put("status", HttpStatus.NOT_FOUND.name());
		
		return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
		
	}
}
