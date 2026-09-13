package com.p1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.p1.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("v1/api/students")
@RequiredArgsConstructor
public class StudentController {
	
	private final StudentService service;
	
//	post
	
	
//	Get

}
