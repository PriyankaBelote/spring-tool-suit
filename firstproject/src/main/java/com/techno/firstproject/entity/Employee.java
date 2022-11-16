package com.techno.firstproject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	private String empName;
	private String empEmailId;
	private String empPassword;
	private int empAge;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
	@JsonIgnore
	private List<EmployeeAddress> employeeAddress;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
	@JsonIgnore
	private List<EmployeeBankInfo> employeeBankInfo;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "employee")
	@JsonIgnore
	private EmployeeDepartment employeeDepartment;

}
