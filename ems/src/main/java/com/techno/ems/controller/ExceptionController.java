package com.techno.ems.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.techno.ems.dto.ResponseDto;
import com.techno.ems.exception.EmpException;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(EmpException.class)

	public ResponseEntity<?> exceptionHandler(HttpServletRequest request, EmpException empException) {
		return new ResponseEntity<>(new ResponseDto(false, empException.getMessage(), null), HttpStatus.BAD_REQUEST);

	}
	
}
