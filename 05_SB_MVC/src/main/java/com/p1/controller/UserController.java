package com.p1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.p1.Student;

@Controller
//@RestController
public class UserController {
	
	@GetMapping("/test")
	@ResponseBody
	public String welcomeMsg() {
		return "Hello i am Spring WEB MVC";
	}
	
	@GetMapping("/testpage")
	public String welcometMsg() {
		return "hello";
	}
	
	
//	one value show on html page
	@GetMapping("/duser")
	public String welcomedynamic(Model model) {
		model.addAttribute("name", "Amit kumar");
		return "index";
	}
	
//	OBJECT return OBject
	 @GetMapping("/student")
	   public String StudentData(Model model) {
		   Student s1 = new Student(1,"anil");
		   model.addAttribute("student", s1);
		   return "student";
	   }
	
//	Json
	@GetMapping("/studentjson")
	public Student studentData(){
		return new Student(1, "amit");
	}
	
	
	
	

}
