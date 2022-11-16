package com.techno.ems.dto;

import java.util.List;

import com.techno.ems.entity.EmployeeAddress;
import com.techno.ems.entity.EmployeeBankInfo;
import com.techno.ems.entity.EmployeeDepartment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDto {
	private int empId;
	private String empName;
	private String empEmailId;
	private String empPassword;
	private int empAge;

	private List<EmployeeAddress> employeeAddress;

	private List<EmployeeBankInfo> employeeBankInfo;

	private EmployeeDepartment employeeDepartment;
}
