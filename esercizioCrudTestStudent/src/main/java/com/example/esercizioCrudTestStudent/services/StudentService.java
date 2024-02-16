package com.example.esercizioCrudTestStudent.services;

import com.example.esercizioCrudTestStudent.entities.Student;
import com.example.esercizioCrudTestStudent.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void setStudentWorkingStatus (Long studentId, boolean isWorking){
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isEmpty()){
            return;
        }
        else {
            student.get().setWorking(isWorking);
            studentRepository.saveAndFlush(student.get());
        }
    }
}