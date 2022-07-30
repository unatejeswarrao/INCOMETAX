package com.imginno.incomeTax.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imginno.incomeTax.model.Employee;
public interface EmployeeReopsitory extends JpaRepository<Employee, Integer> {
	
	Employee findById(int id);
}
