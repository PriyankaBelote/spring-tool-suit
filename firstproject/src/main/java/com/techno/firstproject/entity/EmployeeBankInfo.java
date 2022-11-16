package com.techno.firstproject.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class EmployeeBankInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bankId;
	private String bankName;
	private String ifscCode;
	private long accNo;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Employee employee;
}
