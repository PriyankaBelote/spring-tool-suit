package com.techno.employeefull.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techno.employeefull.dto.LoginDto;
import com.techno.employeefull.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee,String>{

	
	Employee findByEmpId(String empId);

}
