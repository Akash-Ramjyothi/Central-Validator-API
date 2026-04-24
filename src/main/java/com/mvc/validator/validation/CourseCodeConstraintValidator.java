package com.mvc.validator.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Validator implementation for @CourseCode annotation.
 * Validates that the given String starts with the configured prefix.
 */
public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        this.coursePrefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        // Let @NotNull handle null validation if required
        if (value == null) {
            return true;
        }

        // Trim to avoid accidental whitespace issues
        String trimmedValue = value.trim();

        // Basic validation check
        boolean isValid = trimmedValue.startsWith(coursePrefix);

        // Optional: Custom message handling (more control if needed)
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    "Course code must start with '" + coursePrefix + "'"
            ).addConstraintViolation();
        }

        return isValid;
    }
}
