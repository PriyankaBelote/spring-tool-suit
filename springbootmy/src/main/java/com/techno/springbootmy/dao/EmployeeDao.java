package com.techno.springbootmy.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.techno.springbootmy.entity.Employee;

public interface EmployeeDao extends CrudRepository<Employee, String> {
	
	public Employee findByEmpId(String empId);

	 
	
//	@Query("from Employee where empName like'p%'")
//	public Employee getAllEmployee();

}
