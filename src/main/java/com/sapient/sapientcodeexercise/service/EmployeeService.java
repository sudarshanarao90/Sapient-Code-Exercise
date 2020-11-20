package com.sapient.sapientcodeexercise.service;

import java.util.List;
import com.sapient.sapientcodeexercise.entity.Employee;

public interface EmployeeService {
	
	public void updateEmployees(List<Employee> empList) throws NullPointerException;
	
	public List<Employee> listOfEmployees() throws NullPointerException;
	
	public List<Double> rangeOfSalariesByCompetency(String competency) throws Exception;
	
	public List<Employee> getEmployeesByPlace(String place);

}
