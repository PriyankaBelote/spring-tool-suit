package com.techno.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techno.ems.dto.LoginDto;
import com.techno.ems.dto.RegisterDto;
import com.techno.ems.dto.ResponseDto;
import com.techno.ems.dto.UpdateDto;
import com.techno.ems.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/register")
	public ResponseEntity<ResponseDto> getRegister(@RequestBody RegisterDto registerDto) {

		return new ResponseEntity<>(new ResponseDto(false, "successfully registered", service.getRegister(registerDto)),
				HttpStatus.OK);

	}

	@PostMapping("/login")
	public ResponseEntity<ResponseDto> getLogin(@RequestBody LoginDto loginDto) {
		return new ResponseEntity<>(new ResponseDto(false, "successfully logged in", service.getLogin(loginDto)),
				HttpStatus.OK);

	}

	@GetMapping("/getById/{empId}")
	public ResponseEntity<ResponseDto> getById(@PathVariable Integer empId) {

		return new ResponseEntity<>(new ResponseDto(false, "found", service.getById(empId)), HttpStatus.OK);

	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDto> getDeleted(@PathVariable Integer empId) {

		return new ResponseEntity<>(new ResponseDto(false, "deleted", service.getDeleted(empId)), HttpStatus.OK);

	}

	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDto> getUpdate(@PathVariable Integer empId, @RequestBody UpdateDto updateDto) {

		return new ResponseEntity<>(new ResponseDto(false, "updated", service.getUpdated(empId, updateDto)),
				HttpStatus.OK);

	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {

		List<RegisterDto> list = service.getAll();
		if (list != null) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
		return null;

	}

}
