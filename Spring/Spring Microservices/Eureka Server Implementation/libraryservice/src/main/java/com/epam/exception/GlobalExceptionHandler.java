package com.epam.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.epam.dto.ErrorDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(LibraryNotFoundException.class)
	public ResponseEntity<ErrorDTO> libraryNotFoundException(LibraryNotFoundException exception) {

		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setHttpStatus(HttpStatus.NOT_FOUND.value());
		errorDTO.setMessage(exception.getLocalizedMessage());
		errorDTO.setTimestamp(LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);

	}

}
