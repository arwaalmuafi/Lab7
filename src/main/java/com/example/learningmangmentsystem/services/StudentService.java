package com.example.learningmangmentsystem.services;

import com.example.learningmangmentsystem.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    ArrayList<Student>students=new ArrayList<>();

    public ArrayList<Student> getStudents() {
        return students;
    }


    public void addStudent(Student student){
        students.add(student);
    }

    public boolean updateStudent(String id,Student student){
        for (int i = 0; i <students.size() ; i++) {
            if(students.get(i).getId().equals(id)){
                students.add(student);
                return true;
            }

        }
        return false;
    }

    public boolean deleteStudent(String id,Student student){
        for (int i = 0; i < students.size() ; i++) {
            if(students.get(i).getId().equals(id)){
                students.remove(student);
                return true;
            }

        }
        return false;
    }


    public boolean searchStudent(String id,Student student){
        for (int i = 0; i <students.size() ; i++) {
            if (students.get(i).getId().equals(id)){
                return true;
            }


        }
        return false;
    }

    public ArrayList<Student> listCourse(String course){
        ArrayList<Student> courses=new ArrayList<>();
        for(Student student1:students){
            if(student1.getCourse().equalsIgnoreCase(course)){
                courses.add(student1);

            }
        }
        return courses;
    }


    public ArrayList<Student> getStudentsByAge(int age) {
        ArrayList<Student> studentsByAge = new ArrayList<>();
        for (Student student : students) {
            if (student.getAge() == age) {
                studentsByAge.add(student);
            }
        }
        return studentsByAge;
    }

}
