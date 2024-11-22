package com.example.learningmangmentsystem.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    @NotEmpty(message = "ID must be not empty")
    @Size(min = 4, message = "ID should be more then 3")
    private String id;

    @NotEmpty(message = "name should be not empty")
    @Size(min = 4,message = "name should be more then 3 character")
    private String name;

    @Email
    private String email;

    @NotEmpty(message = "Department should not be empty")
    @Size(min = 3, message = "Department should be longer than 3 characters")
    private String department;
}
