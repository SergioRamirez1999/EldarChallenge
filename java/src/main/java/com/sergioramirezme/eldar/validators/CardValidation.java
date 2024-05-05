package com.sergioramirezme.eldar.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CardValidator.class)
@Documented
public @interface CardValidation {

    String message() default "{payments.validation.msg.duedate.expiration}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
