package com.te.springboottable.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
@Entity
@Data
@Table(name = "EmployeeEducationalInfo")
@Component
public class EmployeeEducational implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eduId;
	private String qualifiaction;
	private Integer marks;
	private String yop;
	private String university;
	private String institute;
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference 
	private Employee employeePrimaryInfo;
}
