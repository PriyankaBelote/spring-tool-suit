package com.techno.springbootmy.service;

import com.techno.springbootmy.entity.Employee;

public interface EmployeeService {

	public Employee getEmployeeById(String empId);

	public Employee getRegister(Employee employee);

	public void getDeleted(String empId);

	public Employee getUpdated(Employee employee);

}
