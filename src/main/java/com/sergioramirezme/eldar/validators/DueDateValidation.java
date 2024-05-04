package com.sergioramirezme.eldar.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DueDateValidator.class)
@Documented
public @interface DueDateValidation {

    String message() default "{payments.validation.msg.duedate}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
