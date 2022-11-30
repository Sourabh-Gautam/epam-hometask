package com.epam.microservices.userservices.exceptions;

public class UserManagementException extends Exception{
    public UserManagementException(){

    }
    public UserManagementException(String message){
        super(message);
    }
}
