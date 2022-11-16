package com.te.springboottable.dto;

import java.util.List;

import com.te.springboottable.entity.EmployeeEducational;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class EmployeeDataReturn {
	private String empId;
	private String empAge;
	private String empName;
	private String doj;
	
	private List<EmployeeEducational> educational;
}
