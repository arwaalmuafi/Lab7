package com.example.learningmangmentsystem.Controller;

import com.example.learningmangmentsystem.ApiReasponse.ApiReaspones;
import com.example.learningmangmentsystem.Model.Course;
import com.example.learningmangmentsystem.services.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vpi/v1/course")
@RequiredArgsConstructor
public class CourseController {


    private final CourseService courses;
    @GetMapping("/get")
    public ResponseEntity getCourse( Course course){
        courses.getCourses(course);
        return ResponseEntity.status(200).body(course);
    }

    @PostMapping("/add")
    private ResponseEntity addCourse(@RequestBody @Valid Course course ,Errors errors){
        if(errors.hasErrors()){
            String massage=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massage);
        }
        courses.addCourse(course);
        return ResponseEntity.status(200).body(courses);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable String id, @RequestBody @Valid Course course, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean isuUpdated = courses.updateCourse(id, course);
        if (isuUpdated) {
            return ResponseEntity.status(200).body(new ApiReaspones("Course updated"));
        }
        return ResponseEntity.status(200).body(new ApiReaspones("Course not found"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable String id,Course course) {
        boolean isDeleted = courses.deleteCourse(id,course);
        if (isDeleted) {
            return ResponseEntity.status(200).body(new ApiReaspones("Course deleted"));
        }
        return ResponseEntity.status(400).body(new ApiReaspones("Course not found"));
    }

    @GetMapping("/search/{id}")
    public ResponseEntity searchCourse(@PathVariable String id,Course course) {
        boolean found = courses.searchCourses(id,course);
        if (found) {
            return ResponseEntity.status(200).body(course);
        }
        return ResponseEntity.status(400).body(new ApiReaspones("Course not found"));
    }


}
