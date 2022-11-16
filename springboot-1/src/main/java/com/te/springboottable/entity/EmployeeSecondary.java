package com.te.springboottable.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
@Entity 
@Data
@Table(name = "EmployeeSecondaryInfo")
@Component
public class EmployeeSecondary implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	private String pan;
	private String height;
	private String doj;
	private String passport;
	private String identifyMark;
	@OneToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private Employee employeePrimaryInfo ;
	
}
