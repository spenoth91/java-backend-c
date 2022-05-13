package com.msglearning.javabackend.exceptions;

public class InvalidUserException extends RuntimeException {
    public InvalidUserException (String message) {
        super(message);
    }
}
