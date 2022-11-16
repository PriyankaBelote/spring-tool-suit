package com.techno.employeemanagement.dto;

import java.util.List;

import com.techno.employeemanagement.entity.EmployeeEducationInfo;
import com.techno.employeemanagement.entity.EmployeeSecondaryInfo;
import com.techno.employeemanagement.entity.EmployeeSkills;

import lombok.Data;

@Data
public class EmployeeDto {

	private String empId;
	private String password;
	private Integer empAge;
	private String empName;
	private String empDesignation;
	private String empBloodGroup;
	private String empEmailId;
	private String empDOB;
	private String empMaritalStatus;
	private String empGender;
	private Integer empDeptNo;

	private EmployeeSecondaryInfo employeeSecondaryInfo;

	private List<EmployeeEducationInfo> employeeEducationInfo;

	private List<EmployeeSkills> employeeSkills;

}
