package com.sergioramirezme.eldar.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;

public class DueDateValidator implements ConstraintValidator<DueDateValidation, LocalDateTime> {
    @Override
    public void initialize(DueDateValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDateTime value, ConstraintValidatorContext context) {
        return false;
    }
}
