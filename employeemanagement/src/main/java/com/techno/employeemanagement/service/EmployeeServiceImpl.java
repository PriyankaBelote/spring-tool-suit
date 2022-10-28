package com.techno.employeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techno.employeemanagement.dao.EmployeeDao;
import com.techno.employeemanagement.entity.EmployeePrimaryInfo;

@Service
public class EmployeeServiceImpl implements EmployeeSevice {
	
	@Autowired
	private EmployeeDao dao;

	@Override
	public EmployeePrimaryInfo getRegister(EmployeePrimaryInfo employeePrimaryInfo) {

		return dao.save(employeePrimaryInfo);
	}
	
	
}
