package com.sapient.sapientcodeexercise.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sapient.sapientcodeexercise.entity.Employee;
import com.sapient.sapientcodeexercise.exceptions.EmployeeValidationException;
import com.sapient.sapientcodeexercise.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PutMapping("/employee/{place}/{percentage}")
	public ResponseEntity<String> updateEmployee(@PathVariable String place,
			 @PathVariable Double percentage) throws EmployeeValidationException {
		if(percentage>55) {
			throw new EmployeeValidationException("Validatoin-percentage is grater than 55");
		}else {
   List<Employee> empList = service.listOfEmployees().stream().filter((emp)->{
	   if(emp.getPlace().equals(place))return true ; 
	   else return false;}).map((e)->{
			   	e.setSalary(e.getSalary()+((e.getSalary()*percentage/100)));
		return e;
	
	}).collect(Collectors.toList());
   
		service.updateEmployees(empList);
		
		}
		return ResponseEntity.ok().build();
		
	}
	
	
	@GetMapping("/rangeofsalariesbycompetency/{competency}")
	public ResponseEntity<List<Double>> getRangeOfSalaryByCompetency(@PathVariable String competency) throws Exception{
		if(competency !=null) {
			List<Double> obj = service.rangeOfSalariesByCompetency(competency);
			return ResponseEntity.ok().body(obj);
		}else {
			throw new EmployeeValidationException("Validatoin-Invalid Competency");
		}
				
	}
	
	@GetMapping("searchbyplace/{place}")
	public ResponseEntity<List<Employee>> searchByPlace(@PathVariable String place) throws EmployeeValidationException{
		if(place !=null) {
		List<Employee> empList	= service.getEmployeesByPlace(place);
			return new ResponseEntity<List<Employee>>(empList, HttpStatus.FOUND);
		}else {
			throw new EmployeeValidationException("Validatoin-place not provided");
		}
	}
	}
