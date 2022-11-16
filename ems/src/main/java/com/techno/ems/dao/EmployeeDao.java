package com.techno.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techno.ems.entity.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	Employee findByEmpId(Integer empId);

	Employee findByEmpEmailId(String empEmailId);

}
