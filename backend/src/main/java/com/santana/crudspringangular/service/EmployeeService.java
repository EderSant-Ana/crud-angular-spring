package com.santana.crudspringangular.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santana.crudspringangular.exception.EmployeeAlreadyRegisteredException;
import com.santana.crudspringangular.exception.ResourceNotFoundException;
import com.santana.crudspringangular.model.Employee;
import com.santana.crudspringangular.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeService {
	
	private EmployeeRepository employeeRepository;

	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
	
	
	public Employee createEmployee(Employee employee) {
		Employee employeeSaved = employeeRepository.findByemailId(employee.getEmailId());
		if(employeeSaved == null){
			return employeeRepository.save(employee);
		}
		throw new EmployeeAlreadyRegisteredException(employee.getEmailId()); 
	}


	public Employee findById(Long id) throws ResourceNotFoundException {
		return employeeRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException(id));
	}


	public Employee updateEmployee(Long id, Employee employee) throws ResourceNotFoundException {
		Employee e = findById(id);
		
		e.setFirstName(employee.getFirstName());
		e.setLastName(employee.getLastName());
		e.setEmailId(employee.getEmailId());
		
		return employeeRepository.save(e);
	}
	
	public void deleteEmployee(Long id) throws ResourceNotFoundException{		
		findById(id);
		employeeRepository.deleteById(id);
	}
	
}
