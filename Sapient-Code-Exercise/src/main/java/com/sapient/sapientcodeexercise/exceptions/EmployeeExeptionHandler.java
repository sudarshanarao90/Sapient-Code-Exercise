package com.sapient.sapientcodeexercise.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sapient.sapientcodeexercise.entity.ErrorData;

@RestControllerAdvice
public class EmployeeExeptionHandler {
	
	@ExceptionHandler(EmployeeValidationException.class)
	public ResponseEntity<ErrorData> handleEmployeeValidationException(EmployeeValidationException exception1){
		ErrorData errorData = new ErrorData();
		errorData.setException(exception1);
		errorData.setErrorDescription(exception1.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorData);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorData> handleException(Exception exception2){
		ErrorData errorData = new ErrorData();
		errorData.setException(exception2);
		errorData.setErrorDescription(exception2.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorData);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ErrorData> handleException(NullPointerException exception3){
		ErrorData errorData = new ErrorData();
		errorData.setException(exception3);
		errorData.setErrorDescription(exception3.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorData);
	}
}
