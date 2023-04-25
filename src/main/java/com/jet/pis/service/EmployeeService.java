package com.jet.pis.service;

import java.util.List;
import java.util.Optional;

import com.jet.pis.model.Employee;


public interface EmployeeService {
	
	public List<Employee> getAllEmployees(); 
	public Employee createEmployee(Employee employee);
	public Optional<Employee> getEmployeeById(long id);
	public Employee updateEmployee(Employee employee, long id);
	public void deleteEmployee(long id);
	

}
