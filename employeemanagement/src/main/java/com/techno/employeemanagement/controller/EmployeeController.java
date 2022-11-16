package com.techno.employeemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techno.employeemanagement.dto.EmployeeDto;
import com.techno.employeemanagement.dto.ResponseDto;
import com.techno.employeemanagement.entity.EmployeePrimaryInfo;
import com.techno.employeemanagement.service.EmployeeSevice;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmployeeController {

	@Autowired
	private EmployeeSevice service;
	@Autowired
	private ModelMapper modelMapper;

	// working
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody EmployeePrimaryInfo employeePrimaryInfo) {
		try {
			service.getRegister(employeePrimaryInfo);
			return new ResponseEntity<EmployeePrimaryInfo>(service.getRegister(employeePrimaryInfo), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("not registered", HttpStatus.BAD_REQUEST);
		}
	}

	// working

	@GetMapping("/employees")
	public List<EmployeePrimaryInfo> getAllEmployees() {
		log.info("Success msg");
		return service.getAllEmployees();
	}

//working
	@GetMapping("/getEmployeeById/{empId}")
	public EmployeePrimaryInfo getEmployee(@PathVariable(name = "empId") String empId) {
		log.info("Successful msg");
		return service.getEmployeeById(empId);
	}
	
	
	//working
	@DeleteMapping("/deleteById/{empId}")
	public ResponseEntity<?> deleteById(@PathVariable(name = "empId") String empId) {
		try {
			service.deleteById(empId);
			return new ResponseEntity<String>("successfully deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("not found", HttpStatus.OK);
		}

	}

	//working
	@PostMapping("/register1")
	public ResponseEntity<?> registerByDto(@RequestBody EmployeeDto employeeDto) {
		try {
			service.getRegisterByDto(employeeDto);
			return new ResponseEntity<>(new ResponseDto(false,"successfully registered",employeeDto),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseDto(true,"not registered",employeeDto),HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/updateByDto/{empId}")
	public EmployeePrimaryInfo updateByDto(@PathVariable(name = "empId") String empId,@RequestBody EmployeeDto employeeDto){
		return service.getUpdate(employeeDto, empId);
		
		
		
	}
	
	
	@PostMapping("/loginById/{empId}")
	public ResponseEntity<?> loginById(@PathVariable(name = "empId") String empId) {
		try {
			service.getLoginById(empId);
			return null;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	
	
}
