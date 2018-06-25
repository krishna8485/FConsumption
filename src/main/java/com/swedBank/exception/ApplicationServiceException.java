package com.swedBank.exception;


public class ApplicationServiceException extends Exception {
    public ApplicationServiceException(Exception exception, String message) {
        super(message, exception);
    }
}