package com.primesoft.exception;

import javax.security.sasl.AuthenticationException;

public class DataProcessingException extends AuthenticationException {
    public DataProcessingException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataProcessingException(String message) {
        super(message);
    }
}
