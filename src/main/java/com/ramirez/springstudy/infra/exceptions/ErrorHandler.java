package com.ramirez.springstudy.infra.exceptions;

import com.auth0.jwt.exceptions.JWTVerificationException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleInvalidArguments(MethodArgumentNotValidException ex) {
        String error = "some fields value is invalid: \n";

        String errFields = ex.getFieldErrors()
                .stream()
                .map(err -> {
                    return "field: " + err.getField() + " - message: " + err.getDefaultMessage();
                })
                .collect(Collectors.joining("\n"));

        return ResponseEntity.badRequest().body(error + errFields);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity handleBadCredentialsAuthentication(BadCredentialsException ex) {
        return ResponseEntity.status(403).body("Access Denied. Please check your login credentials");
    }

    @ExceptionHandler(JWTVerificationException.class)
    public ResponseEntity handleInvalidOrExpiredToken() {
        return ResponseEntity.status(403).body("Access Denied. Invalid or expired token!");
    }
}
