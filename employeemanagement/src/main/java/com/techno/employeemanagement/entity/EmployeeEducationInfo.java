package com.techno.employeemanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity

public class EmployeeEducationInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empEduId;
	private String empQualification;
	private String empPercentage;
	private String empYop;
	private String empUniversity;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private EmployeePrimaryInfo employeePrimaryInfo;
}
