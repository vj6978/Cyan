package com.example.cyan.cyan.exceptions;

public class PostNotFoundException extends Exception{
    public PostNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
