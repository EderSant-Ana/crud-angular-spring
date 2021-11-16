package com.santana.crudspringangular.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javassist.bytecode.CodeAttribute.RuntimeCopyException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeCopyException{
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Long id) {
		super(String.format("Employee with id %d not registered in the system.", id));
	}

}
