package com.example.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

  @ExceptionHandler(AccessDeniedException.class)
  public ResponseEntity<Error> getError(AccessDeniedException accessDeniedException) {
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(getError(accessDeniedException, HttpStatus.FORBIDDEN));
  }

  private Error getError(AccessDeniedException accessDeniedException, HttpStatus status) {
    return new Error(accessDeniedException.getMessage(), status);
  }

  record Error(String errorMessage, HttpStatus httpStatus) {
  }
}
