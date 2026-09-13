package com.p1.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity

public class User {
	
	int id;
	String name;
	String email;
	String phone;
	
	

}
