package com.ramirez.springstudy.infra.exceptions;

public class ValidationException extends Throwable {
    public ValidationException(String message) {
        super(message);
    }
}
