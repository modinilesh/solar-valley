package com.solarvalley.exceptions;

public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException(String msg){
        super(msg);
    }
}
