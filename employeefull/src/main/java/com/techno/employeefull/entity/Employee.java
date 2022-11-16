package com.techno.employeefull.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
	private String empId;
	private String empName;
	private String emailId;
	private String empPassword;
}
