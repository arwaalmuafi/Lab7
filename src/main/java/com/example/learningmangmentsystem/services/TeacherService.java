package com.example.learningmangmentsystem.services;

import com.example.learningmangmentsystem.Model.Teacher;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {

    ArrayList<Teacher> teachers = new ArrayList<>();

    public ArrayList<Teacher> getTeachers(@Valid Teacher teacher) {
        return teachers;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public boolean updateTeacher(String id, Teacher teacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId().equals(id)) {
                teachers.add(teacher);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTeacher(String id, Teacher teacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId().equals(id)) {
                teachers.remove(teacher);
                return true;
            }
        }
        return false;
    }

    public boolean searchTeachers(String id, Teacher teacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean findTeacherByName(String name) {
        for (Teacher teacher : teachers) {
            if (teacher.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }


    public boolean findTeacherByDepartment(String department) {
        for (Teacher teacher : teachers) {
            if (teacher.getDepartment().equalsIgnoreCase(department)) {
                return true;
            }
        }
        return false;
    }
}
