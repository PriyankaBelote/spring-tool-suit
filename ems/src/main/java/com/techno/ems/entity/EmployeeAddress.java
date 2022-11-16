package com.techno.ems.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
}
