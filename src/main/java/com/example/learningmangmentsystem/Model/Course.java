package com.example.learningmangmentsystem.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course {

    @NotEmpty(message = "ID should not be empty")
    @Size(min = 5,message = "ID should be longer then 4")
    private String id;


    @NotEmpty(message = "title should not be empty")
    @Size(min = 3, message = "title should be longer then 5 character")
    private String title;

    @NotEmpty(message = "description should not be empty")
    @Size(min = 10,message = "description should be more then 10 character")
    private String description;
}
