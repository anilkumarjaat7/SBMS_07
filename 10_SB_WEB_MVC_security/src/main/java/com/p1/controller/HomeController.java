package com.p1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.p1.service.CourseService;
import com.p1.service.ReviewService;

@Controller
public class HomeController {
	
	private CourseService courseService;

    private ReviewService reviewService;


    public HomeController(CourseService courseService,
                          ReviewService reviewService) {

        this.courseService = courseService;
        this.reviewService = reviewService;
    }
    
    
    @GetMapping({"/","/home"})
    public String home() {
    	
    	return "index";
    }

}
