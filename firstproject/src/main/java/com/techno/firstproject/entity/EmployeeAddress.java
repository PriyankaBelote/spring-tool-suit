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
public class EmployeeAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addId;
	private String addType;
	private String address;
	private String state;
	private int pinCode;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Employee employee;
}
