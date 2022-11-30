package com.epam.microservices.libraryservice.exception;

public class LibraryManagementException extends  Exception {
    public LibraryManagementException() {
    }

    public LibraryManagementException(String message) {
        super(message);
    }
}
