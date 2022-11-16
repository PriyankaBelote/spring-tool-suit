package com.techno.firstproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techno.firstproject.dto.RegisterDto;
import com.techno.firstproject.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	Employee findByEmpId(int empId);

}
