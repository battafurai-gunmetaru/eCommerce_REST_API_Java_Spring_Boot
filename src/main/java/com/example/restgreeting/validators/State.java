package com.example.restgreeting.validators;

import javax.validation.Constraint;

@Constraint(validatedBy = StateValidator.class)
public @interface State {

  String message() default "State must be an officially recognized abbreviation for US State or the District of Columbia";

  // might need to include class groups default and extends payload default

}
