package com.soft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

// Entity  Repo  Server controller   Component


//SpringBootConfiguration
// @EnableAutoConfiguration
// CompmponentScan("com.soft") (com

@SpringBootApplication
@ComponentScan("com.dev.p1")
@ComponentScan("com.soft.p1")
public class Application {

	public static void main(String[] args) {
		 SpringApplication.run(Application.class, args);
		 
//		 standalone App
//		 web 
		
	
	}

}
