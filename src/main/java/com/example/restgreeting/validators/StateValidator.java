package com.example.restgreeting.validators;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StateValidator implements ConstraintValidator<State, String> {

  @Override
  public boolean isValid(String state, ConstraintValidatorContext context) {

    final List<String> states = Arrays.asList("AL", "AK", "AR", "AZ", "CA", "CO", "CT", "DC", "DE",
        "FL", "GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN",
        "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA",
        "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY");

    return states.contains(state);
  }

}
