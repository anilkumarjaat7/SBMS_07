package com.p1.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p1.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
