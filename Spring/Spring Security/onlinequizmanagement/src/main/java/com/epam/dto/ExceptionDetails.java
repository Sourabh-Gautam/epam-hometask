package com.epam.dto;

import java.time.LocalTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ExceptionDetails {
	private final HttpStatus httpStatus;
	private final String message;
	private LocalTime timestamp = LocalTime.now();
}
