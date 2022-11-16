package com.techno.employeefull.dto;

import com.techno.employeefull.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class LoginDto {
	private String empId;
	private String empPassword;


}
