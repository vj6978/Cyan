package com.example.cyan.cyan.exceptions;

public class PostTypeNotSupportedException extends Exception{
    public PostTypeNotSupportedException(String errorMessage){
        super(errorMessage);
    }
}
