package com.p1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.p1.entity.Course;
import com.p1.repository.CourseRepository;



@Service
public class CourseService {

    private final CourseRepository repository;


    public CourseService(CourseRepository repository) {

        this.repository = repository;
    }


    // CREATE / UPDATE

    public Course saveCourse(Course course) {

        return repository.save(course);
    }


    // READ ALL

    public List<Course> getAllCourses() {

        return repository.findAll();
    }


    // READ ONE

    public Course getCourseById(int id) {

        return repository.findById(id).orElse(null);
    }


    // DELETE

    public void deleteCourse(int id) {

        repository.deleteById(id);
    }


    // SEARCH

    public List<Course> searchCourse(String keyword) {

        return repository
                .findByNameContainingIgnoreCase(keyword);
    }
}