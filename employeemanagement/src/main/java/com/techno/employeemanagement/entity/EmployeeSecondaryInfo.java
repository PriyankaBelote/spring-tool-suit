package com.techno.employeemanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeSecondaryInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empSecId;
	private String empPanCard;
	private String empMotherName;
	private String empFatherName;
	private String empHeight;
	private String empDoj;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private EmployeePrimaryInfo employeePrimaryInfo;
}
