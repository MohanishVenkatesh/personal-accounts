package com.mohanish.personalaccounts.validations;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SanitizedValidator implements ConstraintValidator<Sanitized, String> {

    @Override
    public void initialize(Sanitized constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // Implement your sanitization logic here
        String sanitizedValue = value.replaceAll("[^a-zA-Z0-9]", "");

        // Check if the sanitized value is equal to the original value
        return sanitizedValue.equals(value);
    }
}
