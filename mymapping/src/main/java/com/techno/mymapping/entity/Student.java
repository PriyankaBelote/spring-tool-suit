package com.techno.mymapping.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Student {
	@Id
	private String stdId;
	private String stdName;
	private String stdAge;
}
