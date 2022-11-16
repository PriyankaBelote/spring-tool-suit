package com.techno.employeefull.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techno.employeefull.dao.EmployeeDao;
import com.techno.employeefull.dto.LoginDto;
import com.techno.employeefull.dto.RegistrationDto;
import com.techno.employeefull.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao dao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public RegistrationDto registerByDto(RegistrationDto registrationDto) {
		Employee request = modelMapper.map(registrationDto, Employee.class);
		dao.save(request);
		return modelMapper.map(request, RegistrationDto.class);
	}

	@Override
	public RegistrationDto loginByDto(LoginDto loginDto) {
		if (loginDto.getEmpId().startsWith("TYC")) {
			 Employee employee = dao.findByEmpId(loginDto.getEmpId());
			if (employee.getEmpPassword().equals(loginDto.getEmpPassword())) {
				return this.modelMapper.map(employee, RegistrationDto.class);
			}
		}
		return null;

	}

}