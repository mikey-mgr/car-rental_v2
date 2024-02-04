package com.Mike.Proj.exceptions;

public class AuthenticationFailException extends IllegalArgumentException{
    public AuthenticationFailException(String message){
        super(message);
    }

}
