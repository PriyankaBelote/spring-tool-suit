package com.techno.employeefull.service;

import com.techno.employeefull.dto.LoginDto;
import com.techno.employeefull.dto.RegistrationDto;

public interface EmployeeService {

	RegistrationDto registerByDto(RegistrationDto registrationDto);

	RegistrationDto loginByDto(LoginDto loginDto);

}
