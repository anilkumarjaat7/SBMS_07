package com.p1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p1.entity.Student;

public interface StudentRepository extends JpaRepository<Student , Long>{

}
