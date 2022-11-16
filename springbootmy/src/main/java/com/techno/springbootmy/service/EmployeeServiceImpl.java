package com.techno.springbootmy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techno.springbootmy.dao.EmployeeDao;
import com.techno.springbootmy.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao dao;

	@Override
	public Employee getEmployeeById(String empId) {
		return dao.findByEmpId(empId);
	}

	@Override
	public Employee getRegister(Employee employee) {
		return dao.save(employee);

	}

	@Override
	public void getDeleted(String empId) {
		dao.deleteById(empId);

	}

	@Override
	public Employee getUpdated(Employee employee) {
		return dao.save(employee);
	}

}
