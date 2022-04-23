package com.example.restgreeting.exceptions;

import static com.example.restgreeting.constants.StringConstants.VALIDATION_ERROR;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {

  private final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Object> handleValidationExceptions(
      MethodArgumentNotValidException ex) {
    List<String> errors = new ArrayList<>();
    String method = ex.getParameter().getMethod().getName();
    String controller = ex.getParameter().getDeclaringClass().getSimpleName();
    ex.getBindingResult().getAllErrors().forEach(error -> {
      String errorMessage = error.getDefaultMessage();
      errors.add(errorMessage);
    });

    ValidationExceptionResponse response = new ValidationExceptionResponse(VALIDATION_ERROR,
        new Date(), "One or more validation errors occurred in:" + controller + " : " + method,
        errors);

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }
}
