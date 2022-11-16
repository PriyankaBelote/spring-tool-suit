package com.techno.employeefull.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techno.employeefull.dto.LoginDto;
import com.techno.employeefull.dto.RegistrationDto;
import com.techno.employeefull.dto.ResponseDto;
import com.techno.employeefull.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/register")
	public ResponseEntity<?> registerByDto(@RequestBody RegistrationDto registrationDto) {
		try {
			service.registerByDto(registrationDto);
			return new ResponseEntity<ResponseDto>(
					new ResponseDto(false, "successfull", service.registerByDto(registrationDto)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ResponseDto>(
					new ResponseDto(true, "not registered", service.registerByDto(registrationDto)),
					HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/login")
	public ResponseEntity<?> loginByDto(@RequestBody LoginDto loginDto) {
		if (service.loginByDto(loginDto) != null) {
			return new ResponseEntity<>(new ResponseDto(false, "successfull login", service.loginByDto(loginDto)),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ResponseDto(true, "not found", service.loginByDto(loginDto)),
					HttpStatus.BAD_REQUEST);
		}

	}

}
