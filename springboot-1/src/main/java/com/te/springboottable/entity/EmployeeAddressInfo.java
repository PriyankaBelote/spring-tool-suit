package com.te.springboottable.entity;

import java.io.Serializable;

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
public class EmployeeAddressInfo implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addId;
	private String addType;
	private String address;
	private String state;
	private String country;
	private int pinCode;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private Employee employee;
	
}
