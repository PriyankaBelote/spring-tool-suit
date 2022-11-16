package com.techno.firstproject.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techno.firstproject.dao.EmployeeDao;
import com.techno.firstproject.dto.RegisterDto;
import com.techno.firstproject.entity.Employee;
import com.techno.firstproject.entity.EmployeeAddress;
import com.techno.firstproject.entity.EmployeeBankInfo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public RegisterDto getRegister(RegisterDto registerDto) {
		Employee map = modelMapper.map(registerDto, Employee.class);
		map.getEmployeeDepartment().setEmployee(map);
		for (EmployeeAddress employeeAddress : map.getEmployeeAddress()) {
			employeeAddress.setEmployee(map);
		}

		for (EmployeeBankInfo bankInfo : map.getEmployeeBankInfo()) {
			bankInfo.setEmployee(map);
		}

		Employee save = dao.save(map);
		RegisterDto map2 = modelMapper.map(save, RegisterDto.class);
		return map2;
	}

	@Override
	public Employee getById(int empId) {
		return dao.findByEmpId(empId);

	}

	@Override
	public Employee getDeleted(int empId) {
		if ((dao.findByEmpId(empId)) != null) {
			Employee findById = dao.findById(empId).get();
			dao.delete(findById);
		}
		
		return null;
	}

	@Override
	public RegisterDto getUpdated(int empId, RegisterDto registerDto) {
		if (dao.findByEmpId(empId) != null) {
			Employee map = modelMapper.map(registerDto, Employee.class);
			map.getEmployeeDepartment().setEmployee(map);
			for (EmployeeAddress employeeAddress : map.getEmployeeAddress()) {
				employeeAddress.setEmployee(map);
			}

			for (EmployeeBankInfo bankInfo : map.getEmployeeBankInfo()) {
				bankInfo.setEmployee(map);
			}

			Employee save = dao.save(map);
			RegisterDto map2 = modelMapper.map(save, RegisterDto.class);
			return map2;
		}
		return null;

	}

}
