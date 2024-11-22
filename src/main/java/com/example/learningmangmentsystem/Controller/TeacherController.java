package com.example.learningmangmentsystem.Controller;

import com.example.learningmangmentsystem.ApiReasponse.ApiReaspones;
import com.example.learningmangmentsystem.Model.Teacher;
import com.example.learningmangmentsystem.services.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vpi/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teachers;

    @GetMapping("/get")
    public ResponseEntity getTeacher(Teacher teacher) {
       teachers.addTeacher(teacher);
            return ResponseEntity.status(200).body(teacher);
    }

    @PostMapping("/add")
    private ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        teachers.addTeacher(teacher);
        return ResponseEntity.status(200).body(teachers);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable String id, @RequestBody @Valid Teacher teacher, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean isUpdated = teachers.updateTeacher(id, teacher);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiReaspones("Teacher updated"));
        }
        return ResponseEntity.status(200).body(new ApiReaspones("Teacher not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable String id, Teacher teacher) {
        boolean isDeleted = teachers.deleteTeacher(id, teacher);
        if (isDeleted) {
            return ResponseEntity.status(200).body(new ApiReaspones("Teacher deleted"));
        }
        return ResponseEntity.status(400).body(new ApiReaspones("Teacher not found"));
    }

    @GetMapping("/search/{id}")
    public ResponseEntity searchTeacher(@PathVariable String id, Teacher teacher) {
        boolean found = teachers.searchTeachers(id, teacher);
        if (found) {
            return ResponseEntity.status(200).body(teacher);
        }
        return ResponseEntity.status(400).body(new ApiReaspones("Teacher not found"));
    }


    @GetMapping("/search/name/{name}")
    public ResponseEntity findTeacherByName(@PathVariable String name) {
        boolean found = teachers.findTeacherByName(name);
        if (found) {
            return ResponseEntity.status(200).body(new ApiReaspones("Teacher found"));
        }
        return ResponseEntity.status(400).body(new ApiReaspones("Teacher not found"));
    }

    @GetMapping("/search/department/{department}")
    public ResponseEntity findTeacherByDepartment(@PathVariable String department) {
        boolean found = teachers.findTeacherByDepartment(department);
        if (found) {
            return ResponseEntity.status(200).body(new ApiReaspones("Teachers found in the department"));
        }
        return ResponseEntity.status(400).body(new ApiReaspones("No teachers found in the department"));
    }
}