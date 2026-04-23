package com.mvc.validator;

import com.mvc.validator.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotNull(message = "Free passes is required")
    @Min(value = 0, message = "Free passes must be greater than or equal to 0")
    @Max(value = 10, message = "Free passes must be less than or equal to 10")
    private Integer freePasses;

    @NotBlank(message = "Postal code is required")
    @Pattern(regexp = "^[a-zA-Z0-9]{5}$", message = "Postal code must be exactly 5 alphanumeric characters")
    private String postalCode;

    @CourseCode(value = "TOPS", message = "Course code must start with TOPS")
    private String courseCode;

    // Getters and Setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
