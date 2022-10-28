package com.techno.employeemanagement.dao;

import org.springframework.data.repository.CrudRepository;

import com.techno.employeemanagement.entity.EmployeePrimaryInfo;

public interface EmployeeDao extends CrudRepository<EmployeePrimaryInfo, String>{

}
