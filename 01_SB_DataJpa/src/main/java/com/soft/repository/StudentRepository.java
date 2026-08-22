package com.soft.repository;

import org.springframework.data.repository.CrudRepository;

import com.soft.entity.Student;

public interface StudentRepository extends CrudRepository<Student,Integer >{

}
