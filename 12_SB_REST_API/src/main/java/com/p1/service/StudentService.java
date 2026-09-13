package com.p1.service;

import java.util.List;

import com.p1.dto.StudentRequestDTO;
import com.p1.dto.StudentResponseDTO;


public interface StudentService {

    StudentResponseDTO createStudent(StudentRequestDTO dto);

    List<StudentResponseDTO> getAllStudents();

    StudentResponseDTO getStudentById(Long id);

    StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto);

    StudentResponseDTO patchStudent(Long id, StudentRequestDTO dto);

    void deleteStudent(Long id);

    List<StudentResponseDTO> getStudentsByCourse(String course);

    List<StudentResponseDTO> searchStudents(String name);
}
