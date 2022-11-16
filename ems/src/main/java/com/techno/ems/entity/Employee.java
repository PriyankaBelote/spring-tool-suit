package com.techno.ems.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Employee implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")

	private int empId;
	private String empName;
	private String empEmailId;
	private String empPassword;
	private int empAge;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id", nullable = false, updatable = false)
	@JsonIgnore
	private List<EmployeeAddress> employeeAddress;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id", nullable = false, updatable = false)
	@JsonIgnore
	private List<EmployeeBankInfo> employeeBankInfo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id")
	@JsonIgnore
	private EmployeeDepartment employeeDepartment;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return this.getEmpPassword();
	}

	@Override
	public String getUsername() {
		return this.getEmpEmailId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
