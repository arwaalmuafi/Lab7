package com.example.learningmangmentsystem.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    @NotEmpty(message = "Id should not be empty")
    @Size(min = 4, message = "ID should be longer then 5")
    private String id;


    @NotEmpty(message = "name should be not empty")
    @Size(min = 3, message = "name should be longer then3 character")
    private String name;

    @Email
    private String email;

    @NotEmpty(message = "name should be not empty")
    @Size(min = 3, message = "course should be longer then3 character")
    private String course;

    @NotNull(message = "age should be not null")
    @Min(20)
    private int age;

}
