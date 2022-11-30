package com.epam.microservices.libraryservice.globalexceptionhandling;

import com.epam.microservices.libraryservice.exception.LibraryManagementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<ApiErrorResponse> handleNullPointerException(WebRequest request, NullPointerException e) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
        apiErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        apiErrorResponse.setMessage(e.getMessage());
        apiErrorResponse.setTimeStamp(System.currentTimeMillis());
        apiErrorResponse.setPath(request.getDescription(false));
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = LibraryManagementException.class)
    public  ResponseEntity<ApiErrorResponse> handleQuizManagementException(WebRequest request, LibraryManagementException e) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
        apiErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        apiErrorResponse.setMessage(e.getMessage());
        apiErrorResponse.setTimeStamp(System.currentTimeMillis());
        apiErrorResponse.setPath(request.getDescription(false));
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleValidationException(WebRequest request, MethodArgumentNotValidException e) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
        apiErrorResponse.setError(Objects.requireNonNull(e.getBindingResult().getFieldError()).getField() + " is missing ");
        apiErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        apiErrorResponse.setTimeStamp(System.currentTimeMillis());
        apiErrorResponse.setPath(request.getDescription(false));
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> handleUnknownException(WebRequest request, Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
