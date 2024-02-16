package com.example.esercizioCrudTestStudent.controllers;

import com.example.esercizioCrudTestStudent.entities.Student;
import com.example.esercizioCrudTestStudent.repositories.StudentRepository;
import com.example.esercizioCrudTestStudent.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/student")
public class StudentController {
        @Autowired
        StudentRepository studentRepository;
        @Autowired
        StudentService studentService;
        @PostMapping(path = "/createstudent")
        public @ResponseBody Student create (@RequestBody Student student){
            return studentRepository.saveAndFlush(student);
        }

        @GetMapping(path = "/getall")
        public @ResponseBody List<Student> getAll (){
            return studentRepository.findAll();
        }
        @GetMapping(path = "/getone/{id}")
        public @ResponseBody Student getSingle (@PathVariable long id){
            Optional<Student> student = studentRepository.findById(id);
            if(student.isPresent()){
                return student.get();
            }
            else {
                return null;
            }
        }

        @PutMapping(path = "/patch/{id}")
        public @ResponseBody Student update (@PathVariable long id,@RequestBody Student student){
            student.setId(id);
            return studentRepository.saveAndFlush(student);

        }
        @PutMapping(path = "/{id}/working")
        public void setWorking (@PathVariable long id,@RequestParam boolean working){
            studentService.setStudentWorkingStatus(id, working);

        }
        @DeleteMapping(path = "/{id}")
        public boolean delete (@PathVariable long id){
            try {
                studentRepository.deleteById(id);
                return true;
            }
            catch (IllegalArgumentException e) {
                return false;
            }
        }

}

