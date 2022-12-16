package com.epam.convertor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import feign.FeignException;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> handleException(Exception e) {
		
		Map<String, String> response = new HashMap<>();
		response.put("service", "convertor");
		response.put("timestamp", new Date().toString());
		response.put("error", e.getMessage());
		response.put("status", HttpStatus.NOT_FOUND.name());
		
		return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(FeignException.class)
	public ResponseEntity<Map<String, String>> handleUsingFeignException(FeignException e) {
		
		Map<String, String> response = new HashMap<>();
		response.put("service", "convertor using Feign");
		response.put("timestamp", new Date().toString());
		response.put("error", e.getMessage());
		response.put("status", HttpStatus.NOT_FOUND.name());
		
		return new ResponseEntity<Map<String,String>>(response, HttpStatus.NOT_FOUND);
		
	}
	
	
}
