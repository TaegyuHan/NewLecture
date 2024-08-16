package com.example.boot3.demo.java.exception;

public class NoMinusException extends RuntimeException {
    
    public NoMinusException(String message) {
        super(message);
    }
}