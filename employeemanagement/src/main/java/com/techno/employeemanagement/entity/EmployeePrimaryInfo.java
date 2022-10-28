package com.techno.employeemanagement.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
public class EmployeePrimaryInfo {

	@Id
	private String empId;
	private Integer empAge;
	private String empName;
	private String empDesignation;
	private String empBloodGroup;
	private String empEmailId;
	private String empDOB;
	private String empMaritalStatus;
	private String empGender;
	private Integer empDeptNo;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "employeePrimaryInfo")
	@JsonManagedReference
	private EmployeeSecondaryInfo employeeSecondaryInfo;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employeePrimaryInfo")
	@JsonManagedReference
	private List<EmployeeEducationInfo> employeeEducationInfo;

}
