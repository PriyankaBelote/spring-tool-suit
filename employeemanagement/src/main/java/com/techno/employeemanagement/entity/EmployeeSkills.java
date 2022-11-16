package com.techno.employeemanagement.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
public class EmployeeSkills {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empSkillId;
	private String skills;

	@ManyToMany(cascade = CascadeType.ALL)
	@JsonBackReference
	private List<EmployeePrimaryInfo> employeePrimaryInfo;
}
