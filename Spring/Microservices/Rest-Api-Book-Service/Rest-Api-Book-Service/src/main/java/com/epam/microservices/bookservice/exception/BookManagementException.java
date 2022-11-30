package com.epam.microservices.bookservice.exception;

public class BookManagementException extends Exception{
    public BookManagementException(){

    }
    public BookManagementException (String message) {
        super(message);
    }
}
