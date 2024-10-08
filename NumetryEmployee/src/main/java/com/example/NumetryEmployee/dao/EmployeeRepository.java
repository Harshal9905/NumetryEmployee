package com.example.NumetryEmployee.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NumetryEmployee.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	 Optional<Employee> findByEmail(String email);
	 Optional<Employee> findByMobile(String mobile);
}
