package com.example.CricketGameWithSpring.Exception;

public class InputValidationException extends RuntimeException {
    public InputValidationException(String message) {
        super(message);
    }
}