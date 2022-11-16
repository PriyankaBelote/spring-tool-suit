package com.techno.ems.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.techno.ems.dao.EmployeeDao;
import com.techno.ems.dto.AuthResponse;
import com.techno.ems.dto.LoginDto;
import com.techno.ems.dto.RegisterDto;
import com.techno.ems.dto.UpdateDto;
import com.techno.ems.email.EmailConfig;
import com.techno.ems.email.EmailMessage;
import com.techno.ems.entity.Employee;
import com.techno.ems.exception.EmpException;
import com.techno.ems.jwt.JwtTokenUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;
	@Autowired
	private EmailConfig config;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public RegisterDto getRegister(RegisterDto registerDto) {
		try {
			Employee employee = new Employee();
			BeanUtils.copyProperties(registerDto, employee);
			dao.save(employee);
			BeanUtils.copyProperties(employee, registerDto);
			config.sendMail(registerDto.getEmpEmailId(), EmailMessage.getMess(registerDto.getEmpName(),
					registerDto.getEmpEmailId(), registerDto.getEmpPassword()));

			return registerDto;
		} catch (Exception e) {
			throw new EmpException("not registered");
		}

	}

	@Override
	public AuthResponse getLogin(LoginDto loginDto) {

		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginDto.getEmpEmailId(), loginDto.getEmpPassword()));

			Employee employee = (Employee) authentication.getPrincipal();
			String accessToken = jwtTokenUtil.generateAccessToken(employee);
			return new AuthResponse(employee.getEmpEmailId(), accessToken);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			throw new EmpException("Unauthorized");
		}

	}

	@Override
	public RegisterDto getById(Integer empId) {
		try {
			Employee employee = dao.findByEmpId(empId);
			return new RegisterDto(employee.getEmpId(), employee.getEmpName(), employee.getEmpEmailId(),
					employee.getEmpPassword(), employee.getEmpAge(), employee.getEmployeeAddress(),
					employee.getEmployeeBankInfo(), employee.getEmployeeDepartment());

		} catch (Exception e) {
			throw new EmpException(empId + "not present");
		}
	}

	@Override
	public Employee getDeleted(Integer empId) {

		try {

			Employee findById = dao.findById(empId).orElseThrow(() -> new EmpException("not present"));
			dao.delete(findById);

		} catch (Exception e) {

			throw new EmpException("not found");
		}
		return null;
	}

	@Override
	public List<RegisterDto> getAll() {

		try {
			List<Employee> list = dao.findAll();
			List<RegisterDto> arrayList = new ArrayList<>();
			for (Employee employee : list) {
				RegisterDto registerDto = new RegisterDto(employee.getEmpId(), employee.getEmpName(),
						employee.getEmpEmailId(), employee.getEmpPassword(), employee.getEmpAge(),
						employee.getEmployeeAddress(), employee.getEmployeeBankInfo(),
						employee.getEmployeeDepartment());
				arrayList.add(registerDto);

			}
			return arrayList;

		} catch (Exception e) {
			throw new EmpException("something wrong");
		}

	}

	@Override
	public UpdateDto getUpdated(Integer empId, UpdateDto updateDto) {
		Employee employee = dao.findById(empId).orElseThrow(() -> new EmpException(empId+" this empId not found"));
		employee.setEmpName(updateDto.getEmpName());
		employee.setEmpAge(updateDto.getEmpAge());
		employee.setEmpEmailId(updateDto.getEmpEmailId());
		employee.setEmpPassword(updateDto.getEmpPassword());
		employee.setEmployeeAddress(updateDto.getEmployeeAddress());
		employee.setEmployeeBankInfo(updateDto.getEmployeeBankInfo());
		employee.setEmployeeDepartment(updateDto.getEmployeeDepartment());

		dao.save(employee);
		BeanUtils.copyProperties(employee, updateDto);

		return updateDto;
	}

}
