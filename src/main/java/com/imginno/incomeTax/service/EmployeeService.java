package com.imginno.incomeTax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imginno.incomeTax.model.Employee;
import com.imginno.incomeTax.repository.EmployeeReopsitory;

import javax.transaction.Transactional;
@Service
@Transactional
public class EmployeeService {
	@Autowired
	EmployeeReopsitory empRepo;
	public Employee getEmployeeById(int id) {
		
		return empRepo.findById(id);
		}

}
