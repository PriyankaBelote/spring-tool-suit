package com.te.springboottable.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springboottable.dao.EmployeeDao;
import com.te.springboottable.dto.EmployeeDataReturn;
import com.te.springboottable.dto.EmployeeDto;
import com.te.springboottable.dto.EmployeeTabDto;
import com.te.springboottable.dto.ReturnEmployee;
import com.te.springboottable.entity.Employee;
import com.te.springboottable.entity.EmployeeAddressInfo;
import com.te.springboottable.entity.EmployeeEducational;
import com.te.springboottable.entity.EmployeeExperienceInfo;
import com.te.springboottable.entity.EmployeeTechnicalSkills;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao dao;
	@Autowired
	private ModelMapper mapper;

//	@Autowired
//    private EmployeeEducational educational;
//	@Autowired
//    private EmployeeSecondary secondary;
	@Override
	public Employee register(Employee employee) {
//		educational.setEmployeePrimaryInfo(employee);
//		secondary.setEmployeePrimaryInfo(employee);
		return dao.save(employee);
	}

	@Override
	public Employee getLogin(EmployeeDto dto) {
		Employee employee = dao.findByEmpId(dto.getEmpId());
		if (employee != null && employee.getEmplpoyeeSecondaryInfo() != null) {
			if (employee.getEmplpoyeeSecondaryInfo().getPan().equals(dto.getPan())) {
				return employee;
			} else {

			}
		}
		return null;
	}

	@Override
	public List<EmployeeDataReturn> getAll() {
		List<Employee> findAll = (List<Employee>) dao.findAll();
		List<EmployeeDataReturn> list = new ArrayList<>();
		for (Employee employee : findAll) {
			if (employee.getEmplpoyeeSecondaryInfo() != null) {
				EmployeeDataReturn dataReturn = new EmployeeDataReturn(employee.getEmpId(), employee.getEmpAge(),
						employee.getEmpName(), employee.getEmplpoyeeSecondaryInfo().getDoj(),employee.getEducationInfo());
				list.add(dataReturn);
			}
		}
		return list;
	}

	@Override
	public EmployeeTabDto update(EmployeeTabDto dto) {
         Employee employee = mapper.map(dto, Employee.class);
         Employee save = dao.save(employee);
         return this.mapper.map(save, EmployeeTabDto.class);
	}

	@Override
	public List<ReturnEmployee> getOne(String empId) {
		Employee employee = dao.findByEmpId(empId);
		ReturnEmployee returnEmployee = new ReturnEmployee();
		if (employee != null && employee.getEducationInfo() != null) {
			List<EmployeeEducational> list = new ArrayList<>();
//			returnEmployee.setEduInfo(employee.getEducationInfo());
			returnEmployee.setEmpEmail(employee.getEmplpoyeeSecondaryInfo().getPassport());
			returnEmployee.setEmpName(employee.getEmpName());
			returnEmployee.setEmpId(empId);
			list.addAll(employee.getEducationInfo());
			returnEmployee.setEduInfo(list);
			List<ReturnEmployee> list2 = new ArrayList<>();
			list2.add(returnEmployee);
			return list2;

		}
		return null;
	}

	@Override
	public boolean delete(String empId) {
		boolean isDeleted = false;
		try {
			dao.deleteById(empId);
			isDeleted = true;
		} catch (Exception e) {
		}
		return isDeleted;
	}

	@Override
	public EmployeeTabDto addEmployee(EmployeeTabDto dto) {
		Employee map = this.mapper.map(dto, Employee.class);
		map.getEmplpoyeeSecondaryInfo().setEmployeePrimaryInfo(map);
		for (EmployeeEducational e : map.getEducationInfo()) {
			e.setEmployeePrimaryInfo(map);
		}
		map.getBankInfo().setEmployee(map);
		for (EmployeeExperienceInfo e : map.getExperienceInfo()) {
			e.setEmployee(map);
		}
		map.getContactInfo().setEmployee(map);
		for (EmployeeAddressInfo e : map.getAddressInfo()) {
			e.setEmployee(map);
		}
		List<Employee> list = new ArrayList<>();
		list.add(map);
		List<EmployeeTechnicalSkills> technicalSkills = new ArrayList<>();
		technicalSkills.addAll(map.getTechnicalSkills());
		map.getSalaryInfo().setEmployee(map);
		for (EmployeeTechnicalSkills e : map.getTechnicalSkills()) {
			e.setEmployee(list);
			for (Employee emp : e.getEmployee()) {
				emp.setTechnicalSkills(technicalSkills);
			}
		}

		Employee save = dao.save(map);
		return this.mapper.map(save, EmployeeTabDto.class);
	}

	@Override
	public boolean authenticate(EmployeeDto dto) {
		Employee employee = this.mapper.map(dto, Employee.class);
		Employee employee2 = dao.findByEmpId(employee.getEmpId());
		if (employee2 != null) {
			if (employee2.getEmplpoyeeSecondaryInfo().getPan().equals(dto.getPan())) {
				return true;
			}
		}
		return false;
	}
}
