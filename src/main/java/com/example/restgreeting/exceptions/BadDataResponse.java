package com.example.restgreeting.exceptions;

public class BadDataResponse extends RuntimeException {

  public BadDataResponse() {
  }

  public BadDataResponse(String message) {
    super(message);
  }
}
