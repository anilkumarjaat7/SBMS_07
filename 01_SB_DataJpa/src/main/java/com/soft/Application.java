package com.soft;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.soft.entity.Student;
import com.soft.repository.StudentRepository;

@SpringBootApplication
public class Application {

    private final StudentRepository studentRepository;


    Application(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
		

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		StudentRepository studentRepo = context.getBean(StudentRepository.class);
		
//		save One Student in database
//		Student s = new Student(101,"Lokesh","java Full Stack", 25000.00);		
//		studentRepo.save(s);
		
//		insert into multiple student data
//		Student s1 = new Student(102,"Lokesh","java Full Stack", 25000.00);	
//		Student s2 = new Student(103,"Amit","java Full Stack", 25000.00);	
//		Student s3 = new Student(104,"Sumit","java Full Stack", 25000.00);	
//		Student s4 = new Student(105,"Lokesh","java Full Stack", 25000.00);	
//		Student s5 = new Student(106,"Lokesh","java Full Stack", 25000.00);	
//		Student s6 = new Student(107,"Lokesh","java Full Stack", 25000.00);	
//		
//		List<Student> Students = Arrays.asList(s1,s2,s3,s4,s5,s6);
//		
//		studentRepo.saveAll(Students);
//		
//		System.out.println("Data insert");
		
		
		
//		FindById
		
		Optional<Student> byId = studentRepo.findById(101);
		
		System.out.println(byId);
		
	}
	
	
	
		

	
	

}
