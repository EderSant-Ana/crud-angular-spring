package com.santana.crudspringangular.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.santana.crudspringangular.exception.ResourceNotFoundException;
import com.santana.crudspringangular.model.Employee;
import com.santana.crudspringangular.service.EmployeeService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(value = "/api/v1")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeController {

	private EmployeeService employeeService;
		
	@GetMapping(value = "/employees")
	public List<Employee> findAllEmployees(){
		return employeeService.findAll();
	}
	
	@PostMapping(value = "/employees")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}
	
	@GetMapping(value = "/employees/{id}")
	public Employee findEmployeeById(@PathVariable Long id) throws ResourceNotFoundException{
		return employeeService.findById(id);
	}
	
	@PutMapping(value = "/employees/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Employee updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employee) throws ResourceNotFoundException {
		return employeeService.updateEmployee(id, employee);
	}
	
	@DeleteMapping("/employees/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEmployee(@PathVariable Long id) throws ResourceNotFoundException{
		employeeService.deleteEmployee(id);
	}
	
}
