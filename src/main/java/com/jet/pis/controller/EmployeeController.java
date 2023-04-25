package com.jet.pis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jet.pis.model.Employee;
import com.jet.pis.service.EmployeeService;

@RestController
@RequestMapping("/jet/pis/employee")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping
	public ResponseEntity<Employee> createAddress(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.createEmployee(employee), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployees();
	}
	//API to get department by its id
		@GetMapping("/{id}")
		public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable("id") long id){
			return new ResponseEntity<Optional<Employee>>(employeeService.getEmployeeById(id), HttpStatus.OK);
		}
		//API to update a particular department
		@PutMapping("/{id}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id ,@RequestBody Employee employee){
			return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
		}
		
		//API to delete a particular department
		@DeleteMapping("/{id}")
		public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
			// delete department from DB
			employeeService.deleteEmployee(id);
			return new ResponseEntity<String>("deleted successfully!.", HttpStatus.OK);
		}

}
