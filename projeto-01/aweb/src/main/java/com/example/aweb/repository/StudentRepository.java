package com.example.aweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aweb.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}