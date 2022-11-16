package com.techno.employeemanagement.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techno.employeemanagement.dao.EmployeeDao;
import com.techno.employeemanagement.dto.EmployeeDto;
import com.techno.employeemanagement.entity.EmployeeEducationInfo;
import com.techno.employeemanagement.entity.EmployeePrimaryInfo;
import com.techno.employeemanagement.entity.EmployeeSkills;

@Service
public class EmployeeServiceImpl implements EmployeeSevice {

	@Autowired
	private EmployeeDao dao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EmployeePrimaryInfo getRegister(EmployeePrimaryInfo employeePrimaryInfo) {

		return dao.save(employeePrimaryInfo);
	}

	@Override
	public List<EmployeePrimaryInfo> getAllEmployees() {
		List<EmployeePrimaryInfo> employees = new ArrayList<EmployeePrimaryInfo>();
		dao.findAll().forEach(employee -> employees.add(employee));
		return employees;
	}

	@Override
	public EmployeePrimaryInfo getEmployeeById(String empId) {
		return dao.findById(empId).get();
	}

	@Override
	public EmployeeDto getRegisterByDto(EmployeeDto employeeDto) {
		EmployeePrimaryInfo request = modelMapper.map(employeeDto, EmployeePrimaryInfo.class);
		employeeDto.getEmployeeSecondaryInfo().setEmployeePrimaryInfo(request);
		for (EmployeeEducationInfo educationInfo : employeeDto.getEmployeeEducationInfo()) {
			educationInfo.setEmployeePrimaryInfo(request);
		}
		dao.save(request);
		return employeeDto;
	}

	@Override
	public void deleteById(String empId) {
		dao.deleteById(empId);
	}

	@Override
	public void getLoginById(String empId) {

	}

//	@Override
//	public void updateByDto(String empId, EmployeeDto employeeDto) {
//		EmployeePrimaryInfo employee=dao.findById(empId).get();
//		
//		EmployeePrimaryInfo request = modelMapper.map(employeeDto, EmployeePrimaryInfo.class);
//		employeeDto.getEmployeeSecondaryInfo().setEmployeePrimaryInfo(request);
//		for (EmployeeEducationInfo educationInfo : employeeDto.getEmployeeEducationInfo()) {
//			educationInfo.setEmployeePrimaryInfo(request);
//		}
//		 
//		employee.setEmpName(employeeDto.getEmpName());
//		employee.setEmpEmailId(employeeDto.getEmpEmailId());
//		employee.setPassword(employeeDto.getPassword());
//		
//		
//		
//		dao.save(request);
//		}

	@Override
	public EmployeePrimaryInfo getUpdate(EmployeeDto employeeDto, String empId) {
		String empId2 = employeeDto.getEmpId();
		EmployeePrimaryInfo std = dao.findById(empId2).get();
		std.setEmpAge(employeeDto.getEmpAge());
		std.setEmpBloodGroup(employeeDto.getEmpBloodGroup());
		std.setEmpDeptNo(employeeDto.getEmpDeptNo());
		std.setEmployeeSecondaryInfo(employeeDto.getEmployeeSecondaryInfo());
		std.setEmployeeEducationInfo(employeeDto.getEmployeeEducationInfo());
		return dao.save(std);

//		EmployeePrimaryInfo request = modelMapper.map(employeeDto, EmployeePrimaryInfo.class);
//		request=dao.findById(empId).get();	
//		employeeDto.getEmployeeSecondaryInfo().setEmployeePrimaryInfo(request);
//		for (EmployeeEducationInfo educationInfo : employeeDto.getEmployeeEducationInfo()) {
//			educationInfo.setEmployeePrimaryInfo(request);
//		}
//        
//        
//        
//        dao.save(request);
//		return employeeDto;
	}

}
