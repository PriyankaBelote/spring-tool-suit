package com.techno.mymapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techno.mymapping.dto.ResponseDto;
import com.techno.mymapping.dto.StudentDto;
import com.techno.mymapping.dto.StudentUpdateDto;
import com.techno.mymapping.service.StudentService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class StudentController {

	@Autowired
	private StudentService service;

//	@Autowired
//	private StudentDto studentDto;

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody StudentDto studentDto) {
		try {

			return new ResponseEntity<ResponseDto>(
					new ResponseDto(false, "Registration successful", service.register(studentDto)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("not registered", HttpStatus.BAD_REQUEST);

		}

	}

	@DeleteMapping("/delete/{stdId}")
	public ResponseEntity<?> delete(String stdId) {
		try {
			service.delete(stdId);
			return new ResponseEntity<String>("deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("not found", HttpStatus.BAD_REQUEST);

		}
	}

//	@PutMapping("/update/{stdId}")
//	public ResponseEntity<?> update(@PathVariable String stdId, @RequestBody StudentUpdateDto studentUpdateDto) {
//		if (service.update(stdId,studentUpdateDto) != null) {
//
//			return new ResponseEntity<>(
//					new ResponseDto(false, "update successful", service.update(stdId,studentUpdateDto)),
//					HttpStatus.OK);
//		}
//		return new ResponseEntity<String>("not updated", HttpStatus.BAD_REQUEST);
//
//	}

	
	
	@PutMapping("/update")
	public ResponseEntity<?> getUpdate(@RequestBody StudentDto studentDto) {
		try {

			return new ResponseEntity<ResponseDto>(
					new ResponseDto(false, "Update successful", service.update(studentDto)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("not updated", HttpStatus.BAD_REQUEST);

		}

	}
}
