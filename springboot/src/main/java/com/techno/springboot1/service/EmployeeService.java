package com.techno.springboot1.service;

import com.techno.springboot1.entity.Employee;

public interface EmployeeService {

	public Employee getEmployeeById(String empId);

	public Employee getRegister(Employee employee);

	public void getDeleted(String empId);

	public Employee getUpdated(Employee employee);

}