package com.techno.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.techno.employeemanagement.dto.EmployeeDto;
import com.techno.employeemanagement.entity.EmployeePrimaryInfo;
import com.techno.employeemanagement.entity.EmployeeSecondaryInfo;

public interface EmployeeSevice {

	EmployeePrimaryInfo getRegister(EmployeePrimaryInfo employeePrimaryInfo);

	List<EmployeePrimaryInfo> getAllEmployees();

	EmployeePrimaryInfo getEmployeeById(String id);

//	void saveOrUpdate(EmployeePrimaryInfo employeePrimaryInfo);

	EmployeeDto getRegisterByDto(EmployeeDto employeeDto);

	void deleteById(String empId);

	void getLoginById(String empId);

	EmployeePrimaryInfo getUpdate(EmployeeDto employeeDto, String empId);

	

}
