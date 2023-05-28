package com.mohanish.personalaccounts.validations;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SanitizedValidator.class)
@Documented
public @interface Sanitized {

    String message() default "Input contains invalid characters.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
