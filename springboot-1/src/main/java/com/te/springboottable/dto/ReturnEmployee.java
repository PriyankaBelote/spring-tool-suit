package com.te.springboottable.dto;

import java.util.List;

import com.te.springboottable.entity.EmployeeEducational;

import lombok.Data;
@Data
public class ReturnEmployee {
private String empId;
private String empName;
private String empEmail;
private List<EmployeeEducational> eduInfo;

}
