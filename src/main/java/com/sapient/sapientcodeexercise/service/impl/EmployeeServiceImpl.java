package com.sapient.sapientcodeexercise.service.impl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.sapient.sapientcodeexercise.entity.Competency;
import com.sapient.sapientcodeexercise.entity.Employee;
import com.sapient.sapientcodeexercise.repo.EmployeeRepo;
import com.sapient.sapientcodeexercise.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepo repo;

	@Override
	public void updateEmployees(List<Employee> employee){
		if(employee != null) {
			repo.saveAll(employee);
		}else {
			throw new NullPointerException("Empty EmployeeList for updating Employees Salaries");
		}}

	@Override
	public List<Employee> listOfEmployees(){
		List<Employee> employeesList = repo.findAll();
		  if(employeesList.isEmpty()) {
			  throw new NullPointerException("EmployeeList from DB is Empty"); 
		  }
		return employeesList;
	}
	
	@Override
	public List<Double> rangeOfSalariesByCompetency(String competency) throws Exception{
		
	List<Employee> list	= repo.findAll();
	
	for(Employee employee : list){
		
		List<Competency> comp = employee.getCompetencies();
			 Iterator<Competency> iterator = comp.iterator();
			 
			 while(iterator.hasNext()) {
				 
			if((iterator.next().getCompetency()).equals(competency)) {
				
				Optional<Employee> max = list.stream().distinct().max((e1, e2)->{
					return e1.getSalary().compareTo(e2.getSalary());
				});
				
				Optional<Employee> min = list.stream().distinct().min((e1, e2)->{
					return e1.getSalary().compareTo(e2.getSalary());
				});
				
				List<Double> range  = new ArrayList<Double>();
				 range.add(max.get().getSalary());
				 range.add(min.get().getSalary());
				 return range;
				 }}}
				throw new Exception();
	}
	
		 
	@Override
	public List<Employee> getEmployeesByPlace(String place){
		
		Pageable PageWithFiveElements = PageRequest.of(0, 5);
		
        List<Employee> pagedResult = repo.findAllByPlace(place, PageWithFiveElements);
        
		return pagedResult;
         
    }

}
