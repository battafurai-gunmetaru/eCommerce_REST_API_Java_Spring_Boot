package com.example.restgreeting.exceptions;

public class UniqueFieldViolation extends RuntimeException {

  public UniqueFieldViolation() {
  }

  public UniqueFieldViolation(String message) {
    super(message);
  }
}
