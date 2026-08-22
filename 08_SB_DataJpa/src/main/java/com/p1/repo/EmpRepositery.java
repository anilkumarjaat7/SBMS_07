package com.p1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.p1.entity.Employee;

public interface EmpRepositery extends CrudRepository<Employee, Integer>{
	
//	select * from employee where ename = :ename;
	public List<Employee> findByEname(String ename);
	
	//select * from employee where esalary = :esalary;
	public List<Employee> findByEsalary(Double salary);
	
//	select * from employee where esalary >= :esalary;
	public List<Employee> findByEsalaryGreaterThanEqual(Double salary);
	
	
     @Query(value= "select * from Employee" , nativeQuery = true)
	public List<Employee> getAllEmpSql();
     
     @Query("from Employee")
     public List<Employee> getAllEmpHQl();
     
     @Query(value="select name,email from student", nativeQuery = true)
     public Employee GetEmpById(Integer id);
}

//  pojo class native

