package com.te.springboot.service;

import java.util.List;

import com.te.springboot.entity.Employee;

public interface EmployeeService {
	public List<Employee> getEmployee();

	public Employee register(Employee employee);

	public Employee login(Employee employee);
}
