package com.example.NumetryEmployee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NumetryEmployee.Entity.Employee;
import com.example.NumetryEmployee.dao.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	 public Employee addEmployee(Employee employee) {
		 // Check if email already exists
	        Optional<Employee> existingEmployeeByEmail = employeeRepository.findByEmail(employee.getEmail());
	        if (existingEmployeeByEmail.isPresent()) {
	            throw new IllegalArgumentException("Email already in use.");
	        }

	        // Check if mobile already exists
	        Optional<Employee> existingEmployeeByMobile = employeeRepository.findByMobile(employee.getMobile());
	        if (existingEmployeeByMobile.isPresent()) {
	            throw new IllegalArgumentException("Mobile number already in use.");
	        }
	        return employeeRepository.save(employee);
	    }

	    public List<Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	    }

	    public Employee getEmployeeById(Long employeeId) {
	        return employeeRepository.findById(employeeId).orElse(null);
	    }

	    public Employee updateEmployee(Long employeeId, Employee employee) {
	        Employee existingEmployee = employeeRepository.findById(employeeId).orElse(null);
	        if (existingEmployee != null) {
	            existingEmployee.setEmployeeName(employee.getEmployeeName());
	            existingEmployee.setDateOfJoining(employee.getDateOfJoining());
	            existingEmployee.setMobile(employee.getMobile());
	            existingEmployee.setEmail(employee.getEmail());
	            existingEmployee.setDesignation(employee.getDesignation());
	            existingEmployee.setSalary(employee.getSalary());
	            existingEmployee.setAlternativeMobile(employee.getAlternativeMobile());
	            return employeeRepository.save(existingEmployee);
	        }
	        return null;
	    }

	    public void deleteEmployee(Long employeeId) {
	        employeeRepository.deleteById(employeeId);
	    }
}
