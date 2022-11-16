package com.te.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springboot.dto.ResponseDTO;
import com.te.springboot.entity.Employee;
import com.te.springboot.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/getAll")
	public ResponseEntity<ResponseDTO> getById() {
		if (service.getEmployee() != null) {
			return new ResponseEntity<>(new ResponseDTO(false, "Id found", null, service.getEmployee()), HttpStatus.OK);
		}
		return new ResponseEntity<>(new ResponseDTO(true, "Id not found", null, null), HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Employee employee) {
		if (service.register(employee) != null) {
			return new ResponseEntity<>(
					new ResponseDTO(false, "Registration successful", service.register(employee), null), HttpStatus.OK);

		}
		return new ResponseEntity<>(new ResponseDTO(true, "Something went wrong", null, null), HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/login")
	public ResponseEntity<ResponseDTO> login(@RequestBody Employee employee) {
		if (service.login(employee) != null) {
			return new ResponseEntity<>(new ResponseDTO(false, "Login successful", service.login(employee), null),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ResponseDTO(true, "invalid credentials", null, null),
					HttpStatus.BAD_REQUEST);
		}
	}
}
