package com.jet.pis.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jet.pis.exception.ResourceNotFoundException;
import com.jet.pis.model.Designation;
import com.jet.pis.model.Employee;
import com.jet.pis.repository.EmployeeRepository;
import com.jet.pis.service.EmployeeService;


@Service
public class EmployeeServiceImpl  implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll() ;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> getEmployeeById(long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee existingEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		existingEmployee.setName(employee.getName());
		return employeeRepository.save(existingEmployee);
		
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ResourcePermission", "Id", id));
		employeeRepository.deleteById(id);
		
	}

}
