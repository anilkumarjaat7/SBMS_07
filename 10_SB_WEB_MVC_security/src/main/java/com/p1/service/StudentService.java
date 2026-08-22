package com.p1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.p1.entity.Student;
import com.p1.repository.StudentRepository;



@Service
public class StudentService {

    private StudentRepository repository;


    public StudentService(StudentRepository repository) {

        this.repository = repository;
    }


    // CREATE / UPDATE

    public void saveStudent(Student student) {

        repository.save(student);
    }


    // READ ALL

    public List<Student> getAllStudents() {

        return repository.findAll();
    }


    // READ ONE

    public Student getStudentById(int id) {

        return repository.findById(id).orElse(null);
    }


    // DELETE

    public void deleteStudent(int id) {

        repository.deleteById(id);
    }


    // SEARCH

    public List<Student> searchStudent(String name) {

        return repository
                .findByNameContainingIgnoreCase(name);
    }
}
