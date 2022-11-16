package com.techno.firstproject.dto;

import java.util.List;

import com.techno.firstproject.entity.EmployeeAddress;
import com.techno.firstproject.entity.EmployeeBankInfo;
import com.techno.firstproject.entity.EmployeeDepartment;

import lombok.Data;

@Data
public class RegisterDto {

	private int empId;
	private String empName;
	private String empEmailId;
	private String empPassword;
	private int empAge;

	private List<EmployeeAddress> employeeAddress;

	private List<EmployeeBankInfo> employeeBankInfo;

	private EmployeeDepartment employeeDepartment;

}
