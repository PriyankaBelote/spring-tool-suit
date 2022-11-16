package com.te.springboottable.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
public class EmployeeExperienceInfo implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eId;
	private int experience;
	private String prevCTC;
	private String prevCompany;
	private  String role;
	private String doReleiving;
	private String prevDOJ;
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private Employee employee;
}
