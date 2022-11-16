package com.techno.firstproject.controller;

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

import com.techno.firstproject.dto.RegisterDto;
import com.techno.firstproject.dto.ResponseDto;
import com.techno.firstproject.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/register")
	public ResponseEntity<ResponseDto> getRegister(@RequestBody RegisterDto registerDto) {
		try {
			return new ResponseEntity<ResponseDto>(
					new ResponseDto(false, "successfully registered", service.getRegister(registerDto)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ResponseDto>(
					new ResponseDto(true, "not registered", service.getRegister(registerDto)), HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/getById/{empId}")
	public ResponseEntity<ResponseDto> getById(@PathVariable int empId) {
		try {
			return new ResponseEntity<ResponseDto>(new ResponseDto(false, "found", service.getById(empId)),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ResponseDto>(new ResponseDto(true, "not found", service.getById(empId)),
					HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDto> getDeleted(@PathVariable int empId) {
		try {
			return new ResponseEntity<ResponseDto>(new ResponseDto(false, "deleted", service.getDeleted(empId)),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ResponseDto>(new ResponseDto(true, "not deleted", service.getDeleted(empId)),
					HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDto> getUpdate(@PathVariable int empId, @RequestBody RegisterDto registerDto) {
		if (service.getUpdated(empId, registerDto) != null) {
			return new ResponseEntity<ResponseDto>(
					new ResponseDto(false, "updated", service.getUpdated(empId, registerDto)), HttpStatus.OK);
		}
		return new ResponseEntity<ResponseDto>(
				new ResponseDto(true, "not updated", service.getUpdated(empId, registerDto)), HttpStatus.BAD_REQUEST);

	}

}
