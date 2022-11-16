package com.te.springboottable.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
@Data
@Entity
public class EmployeeSalaryInfo implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int slno;
	private String ctc;
	private int basic;
	private int bonus;
	private int hrAllowance;
	private int netPay;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private Employee employee;
	
	
}
