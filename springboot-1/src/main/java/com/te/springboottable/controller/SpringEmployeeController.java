package com.te.springboottable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springboottable.dto.EmployeeDataReturn;
import com.te.springboottable.dto.EmployeeDto;
import com.te.springboottable.dto.EmployeeInfo;
import com.te.springboottable.dto.EmployeeTabDto;
import com.te.springboottable.dto.ResponseDto;
import com.te.springboottable.dto.ReturnEmployee;
import com.te.springboottable.entity.Employee;
import com.te.springboottable.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SpringEmployeeController {
	@Autowired
	private EmployeeService service;
	private String empId;

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Employee employee) {

//		employee.getEmplpoyeeSecondaryInfo().setEmployeePrimaryInfo(employee);
//		for (EmployeeEducational e:employee.getEducationInfo()) {
//			e.setEmployeePrimaryInfo(employee);
//		}
		if (service.register(employee) != null) {
			return new ResponseEntity<String>("Data entrered", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("something went wrong", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/login")
	public ResponseEntity<?> getLogin(@RequestBody EmployeeDto dto) {
		Employee employee = service.getLogin(dto);

		if (employee != null) {
			log.debug(empId);
			return new ResponseEntity<>("Welcome " + employee.getEmpName(), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>("something went wrong", HttpStatus.ACCEPTED);

	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		List<EmployeeDataReturn> list = service.getAll();

		if (list != null) {

			return new ResponseEntity<List<EmployeeDataReturn>>(list, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/update")
	public ResponseEntity<?> updateEmployee(@RequestBody EmployeeTabDto dto) {
		if (service.update(dto) != null) {
			return new ResponseEntity<>(new ResponseDto(false,"Updated Successfully", dto), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(new ResponseDto(true,"something went wrong", dto), HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/getOne")
	public ResponseEntity<?> getOne(@RequestBody EmployeeInfo info) {
		List<ReturnEmployee> returnEmployee = service.getOne(info.getEmpId());
		if (returnEmployee != null) {
			return new ResponseEntity<ResponseDto>(new ResponseDto(false,"Successfull",returnEmployee ), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(new ResponseDto(true,info.getEmpId()+" not found", info), HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/delete/{empId}")
	ResponseEntity<?> deleteEmployee(@PathVariable String empId) {
		if (service.delete(empId)) {
			return new ResponseEntity<>("Employee Deleted", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>("Incorrect employeeId", HttpStatus.BAD_REQUEST);
	}
	@PostMapping("/addEmployee")
	public ResponseEntity<?> addEmployee(@RequestBody EmployeeTabDto dto) {
		if(service.addEmployee(dto)!=null){
		return new ResponseEntity<>(new ResponseDto(false,"Successfull",dto ),HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(new ResponseDto(true,"Something went wrong",dto ), HttpStatus.BAD_GATEWAY);
	}
	
	public ResponseEntity<?> authenticate(@RequestBody EmployeeDto dto) {
		if(service.authenticate(dto)) {
			return new ResponseEntity<>(new ResponseDto(false,"LoggedIn",dto ),HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(new ResponseDto(true,"Invalid credentials",dto ),HttpStatus.BAD_REQUEST);
		
	} 
}
