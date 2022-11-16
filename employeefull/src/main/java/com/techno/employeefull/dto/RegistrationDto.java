package com.techno.employeefull.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDto {
	private String empId;
	private String empName;
	private String emailId;
	private String empPassword;

}
