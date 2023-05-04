package com.ramirez.springstudy.infra;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity handleInvalidArguments(ConstraintViolationException ex) {
        String error = "some fields value is invalid: \n";

        String errFields = ex.getConstraintViolations()
                .stream()
                .map(err -> {
                    return "field: " + err.getPropertyPath() + " - message: " + err.getMessage();
                })
                .collect(Collectors.joining("\n"));

        return ResponseEntity.badRequest().body(error + errFields);
    }
}
