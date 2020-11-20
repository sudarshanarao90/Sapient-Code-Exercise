package com.sapient.sapientcodeexercise.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.sapient.sapientcodeexercise.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>, PagingAndSortingRepository<Employee, Integer>{
	
	
	List<Employee> findAllByPlace(String place, Pageable pageable);
		
}