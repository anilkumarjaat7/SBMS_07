package com.p1.dto;

import jakarta.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequestDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "Phone is required")
    private String phone;

    @NotNull(message = "Age is required")
    @Min(value = 10, message = "Age must be greater than 10")
    @Max(value = 100, message = "Invalid age")
    private Integer age;

    @NotBlank(message = "Course is required")
    private String course;

    @NotNull(message = "Fees is required")
    @Positive(message = "Fees must be positive")
    private Double fees;
}