package com.example.NumetryEmployee.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long employeeId;
	 
	 private String employeeName;
	 
	 private LocalDate dateOfJoining;
	 
	 private String mobile;
	 
	 private String email;
	 
	 private String designation;
	 
	 private Double salary;
	 
	 private String alternativeMobile;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getAlternativeMobile() {
		return alternativeMobile;
	}

	public void setAlternativeMobile(String alternativeMobile) {
		this.alternativeMobile = alternativeMobile;
	}

	public Employee(Long employeeId, String employeeName, LocalDate dateOfJoining, String mobile, String email,
			String designation, Double salary, String alternativeMobile) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.dateOfJoining = dateOfJoining;
		this.mobile = mobile;
		this.email = email;
		this.designation = designation;
		this.salary = salary;
		this.alternativeMobile = alternativeMobile;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", dateOfJoining="
				+ dateOfJoining + ", mobile=" + mobile + ", email=" + email + ", designation=" + designation
				+ ", salary=" + salary + ", alternativeMobile=" + alternativeMobile + "]";
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 

}
