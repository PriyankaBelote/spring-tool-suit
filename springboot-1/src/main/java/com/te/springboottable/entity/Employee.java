package com.te.springboottable.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name = "EmployeePrimaryInfo")
@Data
@Component
public class Employee implements Serializable {

	@Id
	private String empId;
	private String empName;
	private String empAge;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employeePrimaryInfo")
	@JsonManagedReference
	private List<EmployeeEducational> educationInfo;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "employeePrimaryInfo")
	@JsonManagedReference
	private EmployeeSecondary emplpoyeeSecondaryInfo;

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name = "Employee_techskills",
	joinColumns = {@JoinColumn(name="emp_id")},
	inverseJoinColumns = {@JoinColumn(name="skid")})
	private List<EmployeeTechnicalSkills> technicalSkills;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
	@JsonManagedReference
	private List<EmployeeAddressInfo> addressInfo;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "employee")
	@JsonManagedReference
	private EmployeeBankInfo bankInfo;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "employee")
	@JsonManagedReference
	private EmployeecontactInfo contactInfo;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "employee")
	@JsonManagedReference
	private EmployeeSalaryInfo salaryInfo;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
	@JsonManagedReference
	private List<EmployeeExperienceInfo> experienceInfo;
}
