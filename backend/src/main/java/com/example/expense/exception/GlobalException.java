package com.example.expense.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.example.expense.DTO.response.ApiResponse;

@RestControllerAdvice
public class GlobalException {
  private ResponseEntity<ApiResponse<?>> buildResponse(String message, HttpStatus status) {
    ApiResponse<?> response = new ApiResponse<>(
        status.value(),
        status.name(),
        message,
        null);
    return ResponseEntity.status(status).body(response);
  }

  @ExceptionHandler(UsernameNotFoundException.class)
  public ResponseEntity<?> handleUsernameNotFound(UsernameNotFoundException ex) {
    return buildResponse(ex.getMessage(), HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler(org.springframework.security.authentication.BadCredentialsException.class)
  public ResponseEntity<?> handleBadCredentialExceptio(Exception ex) {
    return buildResponse(ex.getMessage(), HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler(AuthorizationDeniedException.class)
  public ResponseEntity<?> handleAuthorizationDenied(AuthorizationDeniedException ex) {
    return buildResponse("Access Denied", HttpStatus.FORBIDDEN);
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<?> handleResourceNotFound(ResourceNotFoundException ex) {
    return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(NoResourceFoundException.class)
  public ResponseEntity<?> handleNoResourceFound(NoResourceFoundException ex) {
    return buildResponse("Endpoint not found", HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> handleInternalServerError(Exception ex) {
    ex.printStackTrace();
    return buildResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
