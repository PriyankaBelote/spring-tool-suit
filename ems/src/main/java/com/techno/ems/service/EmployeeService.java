package com.techno.ems.service;

import java.util.List;

import com.techno.ems.dto.AuthResponse;
import com.techno.ems.dto.LoginDto;
import com.techno.ems.dto.RegisterDto;
import com.techno.ems.dto.UpdateDto;
import com.techno.ems.entity.Employee;

public interface EmployeeService {

	RegisterDto getRegister(RegisterDto registerDto);

	RegisterDto getById(Integer empId);

	Employee getDeleted(Integer empId);


	List<RegisterDto> getAll();

	UpdateDto getUpdated(Integer empId, UpdateDto updateDto);

	AuthResponse getLogin(LoginDto loginDto);




}
