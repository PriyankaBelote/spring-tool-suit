package com.te.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.te.springboot.entity.Employee;

public interface EmployeeDao extends CrudRepository<Employee, String> {

	public Employee findByEmpId(String empId);

}
