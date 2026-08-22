package com.p1.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.p1.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{

}
