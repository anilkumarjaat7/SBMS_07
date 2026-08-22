package com.p1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.p1.service.CourseService;
import com.p1.service.ReviewService;

@Controller
public class CourseController {
	
	private CourseService courseService;

     private ReviewService reviewService;

	 public CourseController(CourseService courseService, ReviewService reviewService) {
		super();
		this.courseService = courseService;
		this.reviewService = reviewService;
	 }
     
    
	 
//	 Courses List
	 @GetMapping("/courses")
	 public String Courses(Model model) {
		 
		 return "courses";
	 }
	 
	
	

	
	
}
