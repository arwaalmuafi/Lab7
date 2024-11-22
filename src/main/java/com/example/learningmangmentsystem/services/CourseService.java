package com.example.learningmangmentsystem.services;

import com.example.learningmangmentsystem.Model.Course;
import com.example.learningmangmentsystem.Model.Student;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseService {


    ArrayList<Course>courses=new ArrayList<>();

    public ArrayList<Course> getCourses(@Valid Course course) {
        return courses;
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    public boolean updateCourse(String id, Course course){
        for (int i = 0; i <courses.size() ; i++) {
            if(courses.get(i).getId().equals(id)){
                courses.add(course);
                return true;
            }

        }
        return false;
    }

    public boolean deleteCourse(String id,Course course){
        for (int i = 0; i < courses.size() ; i++) {
            if(courses.get(i).getId().equals(id)){
                courses.remove(course);
                return true;
            }

        }
        return false;
    }


    public boolean searchCourses (String id,Course course){
        for (int i = 0; i < courses.size() ; i++) {
            if (courses.get(i).getId().equals(id)){
                return true;
            }


        }
        return false;
    }




}
