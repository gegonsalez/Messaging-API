package com.flavanoids.API.Exceptions;

public class CustomException extends Exception {

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable error) {
        super(message, error);
    }
}
