package com.example.restgreeting.exceptions;

import java.util.Date;
import java.util.List;

public class ValidationExceptionResponse extends ExceptionResponse {

  public List<String> validationErrors;

  public ValidationExceptionResponse(String errorType, Date date, String errorMessage,
      List<String> errors) {
    super(errorType, date, errorMessage);
    validationErrors = errors;
  }

}
