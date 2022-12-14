package com.techno.springbootmy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techno.springbootmy.entity.Employee;
import com.techno.springbootmy.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/getById/{empId}")
	public ResponseEntity<?> getById(@PathVariable String empId) {
		if (service.getEmployeeById(empId) != null) {
			return new ResponseEntity<Employee>(service.getEmployeeById(empId), HttpStatus.OK);

		}
		return new ResponseEntity<String>("something went wrong", HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Employee employee) {
		if (service.getRegister(employee) != null) {
			return new ResponseEntity<Employee>(service.getRegister(employee), HttpStatus.OK);
		}
		return new ResponseEntity<String>("not registered", HttpStatus.BAD_REQUEST);

	}

	@DeleteMapping("/delete/{empId}")
	public String getDelete(@PathVariable String empId) {
		try {
			service.getDeleted(empId);
			return " deleted successfully";
		} catch (Exception e) {
			return empId + " not found";
		}

	}

	@PutMapping("/update")
	public ResponseEntity<?> getUpdated(@RequestBody Employee employee) {
		if (service.getUpdated(employee) != null) {
			return new ResponseEntity<Employee>(service.getUpdated(employee), HttpStatus.OK);
		}
		return new ResponseEntity<String>("not updated", HttpStatus.BAD_REQUEST);

	}
}
