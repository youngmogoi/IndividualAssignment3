package com.csc340.restapidemo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csc340.restapidemo.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
