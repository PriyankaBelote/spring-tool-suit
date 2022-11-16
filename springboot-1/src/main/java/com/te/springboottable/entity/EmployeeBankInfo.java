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
public class EmployeeBankInfo implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bId;
	private String bankName;
	private String ifscCode;
	private long accNo;
	@OneToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private Employee employee;
}
