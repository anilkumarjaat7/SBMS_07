package com.p1.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.p1.entity.Student;
import com.p1.service.StudentService;

@Controller
public class StudentController {

    private StudentService service;


    public StudentController(StudentService service) {

        this.service = service;
    }


//  create Form
    @GetMapping("/student/new")
    public String createStudent(Model model) {

        Student student = new Student();

        model.addAttribute(
                "student",
                student
        );

        return "student-form";
    }


    // =========================================
    // SAVE STUDENT
    // =========================================

    @PostMapping("/student/save")
    public String saveStudent(
            @ModelAttribute Student student) {

        service.saveStudent(student);

        return "redirect:/students";
    }


    // =========================================
    // VIEW ALL STUDENTS
    // =========================================

    @GetMapping("/students")
    public String viewStudents(Model model) {

        List<Student> students =
                service.getAllStudents();

        model.addAttribute(
                "students",
                students
        );

        return "students";
    }


    // =========================================
    // VIEW STUDENT DETAILS
    // =========================================

    @GetMapping("/student/{id}")
    public String studentDetails(
            @PathVariable int id,
            Model model) {

        Student student =
                service.getStudentById(id);

        model.addAttribute(
                "student",
                student
        );

        return "student-details";
    }


    // =========================================
    // EDIT STUDENT
    // =========================================

    @GetMapping("/student/edit/{id}")
    public String editStudent(
            @PathVariable int id,
            Model model) {

        Student student =
                service.getStudentById(id);

        model.addAttribute(
                "student",
                student
        );

        return "student-form";
    }


    // =========================================
    // DELETE STUDENT
    // =========================================

    @GetMapping("/student/delete/{id}")
    public String deleteStudent(
            @PathVariable int id) {

        service.deleteStudent(id);

        return "redirect:/students";
    }


    // =========================================
    // SEARCH STUDENT
    // =========================================

    @GetMapping("/student/search")
    public String searchStudent(
            @RequestParam String name,
            Model model) {

        List<Student> students =
                service.searchStudent(name);

        model.addAttribute(
                "students",
                students
        );

        return "students";
    }
}

