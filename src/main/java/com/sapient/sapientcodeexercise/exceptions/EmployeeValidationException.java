package com.sapient.sapientcodeexercise.exceptions;

import org.springframework.stereotype.Component;

@Component
public class EmployeeValidationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmployeeValidationException() {
		
	}
	
	public EmployeeValidationException(String message) {
		super(message);
	}
	
	public EmployeeValidationException(String message, Throwable cause) {
		super(message, cause);
	}
	

}
