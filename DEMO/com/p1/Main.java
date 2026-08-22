package com.p1;

class Student {
	private int id;
	private String name;
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
}

public class Main {
	public static void main(String[] args) {
		
		Student s1 = new Student(101,"Ram");
		
		System.out.println(s1);
		
	}

}
