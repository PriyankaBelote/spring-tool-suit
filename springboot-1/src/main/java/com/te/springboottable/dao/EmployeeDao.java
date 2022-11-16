package com.te.springboottable.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.springboottable.entity.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, String> {
	public Employee findByEmpId(String empId);
}
