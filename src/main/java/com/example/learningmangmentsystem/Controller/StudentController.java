package com.example.learningmangmentsystem.Controller;

import com.example.learningmangmentsystem.ApiReasponse.ApiReaspones;
import com.example.learningmangmentsystem.Model.Student;
import com.example.learningmangmentsystem.services.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/vpi/vi/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService students;

    @GetMapping("/get")
    public ResponseEntity getStudent() {
        ArrayList<Student> studentArrayList = students.getStudents();
        return ResponseEntity.status(200).body(studentArrayList);
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student, Errors errors) {
        if (errors.hasErrors()) {
            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massage);
        }

        students.addStudent(student);
        return ResponseEntity.status(200).body(new ApiReaspones("student added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable String id, @RequestBody @Valid Student student, Errors errors) {
        if (errors.hasErrors()) {
            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massage);
        }

        boolean isUpdate = students.updateStudent(id, student);
        if (isUpdate) {
            return ResponseEntity.status(200).body(new ApiReaspones("Student is updated"));
        }
        return ResponseEntity.status(400).body(new ApiReaspones("student is not found"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable String id,Student student){
        boolean isDelete=students.deleteStudent(id,student);
        if(isDelete){
            return ResponseEntity.status(200).body(new ApiReaspones("student is deleted"));
        }
        return ResponseEntity.status(400).body(new ApiReaspones("student not found"));

    }

    @GetMapping("/search/{id}")
    public ResponseEntity searchStudent(@PathVariable String id,Student student){
        boolean isFound=students.searchStudent(id,student);
        if(isFound){
            return ResponseEntity.status(200).body(new ApiReaspones("is found"));
        }
        return ResponseEntity.status(400).body(new ApiReaspones("not found"));
    }


    @GetMapping("/get/{course}")
    public ResponseEntity listCourse(@PathVariable String course) {
        ArrayList<Student> listCourse = students.listCourse(course);
        return ResponseEntity.status(200).body(listCourse);
    }

    @GetMapping("/ages")
    public ResponseEntity getStudentsByAge(int age) {
        ArrayList<Student> studentsByAge = students.getStudentsByAge(age);
        return ResponseEntity.status(200).body(studentsByAge);
    }






}
