package com.p1.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.p1.entity.Employee;
import com.p1.repo.EmpRepositery;

@Service
public class EmpServices {
	
	private EmpRepositery repo;

	public EmpServices(EmpRepositery repo) {
		this.repo = repo;
	}
	
//	saveEmp
	
	public void saveEmployee() {
		Employee emp = new Employee(1,"lokesh",80455.89);
		
//		save()  upsert	
		repo.save(emp);
		
		System.out.println("record Save....");
		
	}
	
	
//	saveEmps
	
	public void saveEmps() {
		Employee e1 = new Employee(201,"ram",90455.89);
		Employee e2 = new Employee(202,"syam",70455.89);
		Employee e3 = new Employee(203,"ghansyam",50985.89);
		Employee e4 = new Employee(204,"lokesh",87968.89);
		Employee e5 = new Employee(205,"devendra",80455.89);
		Employee e6 = new Employee(206,"Sunil",79455.89);
		
		List<Employee> emps = Arrays.asList(e1,e2,e3,e4,e5,e6);
		
		repo.saveAll(emps);
	}
	
	
//	 Emp Find
	
	public void getEmp(Integer id ) {
		
		Optional<Employee> findById = repo.findById(id);
		
		if(findById.isPresent()) {
			Employee employee = findById.get();
			System.out.println(employee);
		}else {
			System.out.println("Record Not Found");
		}
		
	}
	
//	find Emps
	public void getEmps(List<Integer> id ) {
		
		Iterable<Employee> emps = repo.findAllById(id);
		
		emps.forEach(e->System.out.println(e));
		
	}
	
//	findAll
	
	public void getAllEmps() {
		
		Iterable<Employee> emps = repo.findAll();
		
		emps.forEach(e->System.out.println(e));
		
	}
	
	public void callFindByMethod() {
		
		 List<Employee> emps = repo.findByEname("Lokesh");
		
		emps.forEach(e->System.out.println(e));
		
	}
	

}
