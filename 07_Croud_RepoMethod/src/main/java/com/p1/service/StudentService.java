package com.p1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.p1.entity.Student;
import com.p1.repo.StudentRepository;

@Service
public class StudentService {
	
	private StudentRepository repo;


	public StudentService(StudentRepository repo) {
		this.repo = repo;
	}
	
//	create Student
	
	public Student createStudent(Student student) {
		return repo.save(student);
	}
	
	
//	insert into Multiple Student Data
	
	public Iterable<Student> createStudent(List<Student> student) {
	return	repo.saveAll(student);
	}
	
	
//	 Read One
    public Student getStudent(Long id) {
    	return repo.findById(id).orElseThrow(()-> new RuntimeException("Student not Found By Id"));
    	
    }
    
//    Read All
    
    public Iterable<Student> getAllStudents(){
    	return repo.findAll();
    }
    
//    Check
    public boolean StudentExists(Long id) {
    	return repo.existsById(id);
    }
    
//    count 
    public long getStudentCount() {
    	return repo.count();
    }
    
//    Delete By Id
    public void deleteStudent(Long id) {
    	if(repo.existsById(id)) {
    		repo.deleteById(id);
    	}
    	
    }
    
//    Delete By Obj
    
    public void deleteStudent(Student student) {
    	repo.delete(student);
    }
    
    public void deleteStudent() {
    	repo.deleteAll();
    	
    	
    }
    
 
//    save()   saveAll()
    
}
