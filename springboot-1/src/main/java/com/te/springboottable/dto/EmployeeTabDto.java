package com.te.springboottable.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.te.springboottable.entity.EmployeeAddressInfo;
import com.te.springboottable.entity.EmployeeBankInfo;
import com.te.springboottable.entity.EmployeeEducational;
import com.te.springboottable.entity.EmployeeExperienceInfo;
import com.te.springboottable.entity.EmployeeSalaryInfo;
import com.te.springboottable.entity.EmployeeSecondary;
import com.te.springboottable.entity.EmployeeTechnicalSkills;
import com.te.springboottable.entity.EmployeecontactInfo;

import lombok.Data;

@Data
public class EmployeeTabDto {

	private String empId;
	private String empName;
	private String empAge;

	private List<EmployeeEducational> educationInfo;

	private EmployeeSecondary emplpoyeeSecondaryInfo;

	private List<EmployeeTechnicalSkills> technicalSkills;

	private List<EmployeeAddressInfo> addressInfo;

	private EmployeeBankInfo bankInfo;

	private EmployeecontactInfo contactInfo;

	private EmployeeSalaryInfo salaryInfo;

	private List<EmployeeExperienceInfo> experienceInfo;
}
