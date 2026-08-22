package com.p1.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.p1.student.entity.Student;
import com.p1.student.repository.StudentRepository;

@Controller
public class StudentController {

    private StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }


    // READ
    @GetMapping("/students")
    public String students(Model model) {

        model.addAttribute(
            "students",
            repository.findAll()
        );

        return "students";
    }


    // SHOW ADD FORM
    @GetMapping("/students/new")
    public String newStudent(Model model) {

        model.addAttribute(
            "student",
            new Student()
        );

        return "student-form";
    }


    // SAVE
    @PostMapping("/students/save")
    public String saveStudent(
            @ModelAttribute Student student) {

        repository.save(student);

        return "redirect:/students";
    }


    // EDIT
    @GetMapping("/students/edit/{id}")
    public String editStudent(
            @PathVariable int id,
            Model model) {

        Student student =
                repository.findById(id).orElse(null);

        model.addAttribute(
            "student",
            student
        );

        return "student-form";
    }


    // DELETE
    @GetMapping("/students/delete/{id}")
    public String deleteStudent(
            @PathVariable int id) {

        repository.deleteById(id);

        return "redirect:/students";
    }
}




