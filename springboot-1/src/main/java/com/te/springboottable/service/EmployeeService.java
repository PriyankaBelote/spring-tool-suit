package com.te.springboottable.service;

import java.util.List;

import com.te.springboottable.dto.EmployeeDataReturn;
import com.te.springboottable.dto.EmployeeDto;
import com.te.springboottable.dto.EmployeeTabDto;
import com.te.springboottable.dto.ReturnEmployee;
import com.te.springboottable.entity.Employee;

public interface EmployeeService {
public Employee register(Employee employee);
public Employee getLogin(EmployeeDto dto);
public List<EmployeeDataReturn> getAll();
public EmployeeTabDto update(EmployeeTabDto dto); 
	
public List<ReturnEmployee> getOne(String empId);
public boolean delete(String empId);


public EmployeeTabDto addEmployee(EmployeeTabDto dto);

public boolean authenticate(EmployeeDto dto);
}
