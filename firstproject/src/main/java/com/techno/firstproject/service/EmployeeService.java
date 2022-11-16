package com.techno.firstproject.service;

import com.techno.firstproject.dto.RegisterDto;
import com.techno.firstproject.entity.Employee;

public interface EmployeeService {

	RegisterDto getRegister(RegisterDto registerDto);

	Employee getById(int empId);

	Employee getDeleted(int empId);

	RegisterDto getUpdated(int empId, RegisterDto registerDto);

}
