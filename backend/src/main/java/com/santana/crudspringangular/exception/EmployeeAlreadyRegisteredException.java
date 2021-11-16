package com.santana.crudspringangular.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javassist.bytecode.CodeAttribute.RuntimeCopyException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyRegisteredException extends RuntimeCopyException{
	private static final long serialVersionUID = 1L;
	
	public EmployeeAlreadyRegisteredException(String employee_email) {
		super(String.format("Employee %s already registered in the system.", employee_email));
	}

	


}
