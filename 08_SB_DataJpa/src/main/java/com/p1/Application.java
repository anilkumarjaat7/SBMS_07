package com.p1;

import com.p1.service.EmpServices;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {




	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		EmpServices empServices = context.getBean(EmpServices.class);
		
//		empServices.saveEmployee();
		
//		empServices.saveEmps();
		
//		empServices.getEmp(101);
//		
//		empServices.getEmps(Arrays.asList(201,202,203,205));
		
//		empServices.getAllEmps(); 
		
		empServices.callFindByMethod();
		
	}

	
	

}


//   web   Rest   :  student get name/email  post put delete    

