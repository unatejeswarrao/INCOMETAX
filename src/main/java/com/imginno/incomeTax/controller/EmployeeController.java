package com.imginno.incomeTax.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imginno.incomeTax.TaxCalculationUtil;
import com.imginno.incomeTax.model.Employee;
import com.imginno.incomeTax.model.TaxDetail;
import com.imginno.incomeTax.repository.EmployeeReopsitory;

@Controller
public class EmployeeController extends TaxCalculationUtil{

	 @Autowired
	 EmployeeReopsitory emprepo;
	 
	 @PostMapping(value="/student")
	 @ResponseBody
	 public Employee addEmployee(@Valid @RequestBody Employee emp) {
	 return emprepo.save(emp);
	 }
	 @GetMapping(value="/findEmployee")
	 @ResponseBody
	 public Employee findStudent(@RequestParam("empId") int empId) {
	 return emprepo.findById(empId);
	 }

	 @GetMapping(value="/taxDetails")
	 @ResponseBody
	 public TaxDetail getTaxDetail(@Valid @RequestBody int empId) {
	 return getTaxDetails(emprepo.findById(empId));
	 }
	 
	 public TaxDetail getTaxDetails(Employee emp) {
		 
		 TaxDetail taxdtl = new TaxDetail();
		 taxdtl.setId(emp.getId());
		 taxdtl.setFirst_name(emp.getFirstName());
		 taxdtl.setLast_name(emp.getLastName());
		 return calculateTax(emp.getSAL(),taxdtl);
	 }
	
}
