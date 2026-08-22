package com.soft.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Student {
	
	@Id
	private Integer id;
	
	private String name;
	private String courses;
	private Double fees;
	
	
	public Student(Integer id, String name, String courses, Double fees) {
		super();
		this.id = id;
		this.name = name;
		this.courses = courses;
		this.fees = fees;
	}
	
	
	public Student() {
		super();
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourses() {
		return courses;
	}
	public void setCourses(String courses) {
		this.courses = courses;
	}
	public Double getFees() {
		return fees;
	}
	public void setFees(Double fees) {
		this.fees = fees;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", courses=" + courses + ", fees=" + fees + "]";
	}
		

}
