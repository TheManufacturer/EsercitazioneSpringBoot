package com.example.esercizioCrudTestStudent.repositories;

import com.example.esercizioCrudTestStudent.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
