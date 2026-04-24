package com.mvc.validator.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Custom validation annotation to validate course codes.
 * Ensures that the annotated field starts with a specific prefix.
 *
 * Default prefix: "LUV"
 */
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({
        ElementType.FIELD,
        ElementType.METHOD,
        ElementType.PARAMETER,
        ElementType.ANNOTATION_TYPE
})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CourseCode {

    /**
     * Defines the required prefix for the course code.
     * Default is "LUV".
     */
    String value() default "LUV";

    /**
     * Validation error message when constraint is violated.
     */
    String message() default "Course code must start with {value}";

    /**
     * Allows specification of validation groups.
     */
    Class<?>[] groups() default {};

    /**
     * Payload for clients to specify severity or metadata.
     */
    Class<? extends Payload>[] payload() default {};
}
