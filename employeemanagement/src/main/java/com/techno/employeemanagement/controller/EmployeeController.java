package com.techno.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techno.employeemanagement.entity.EmployeePrimaryInfo;
import com.techno.employeemanagement.service.EmployeeSevice;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeSevice service;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody EmployeePrimaryInfo employeePrimaryInfo) {
		try {
			
			
			return new ResponseEntity<EmployeePrimaryInfo>(service.getRegister(employeePrimaryInfo), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("not registered", HttpStatus.BAD_REQUEST);
		}
	}

}
