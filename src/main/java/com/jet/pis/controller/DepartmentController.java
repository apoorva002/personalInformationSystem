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

import com.jet.pis.model.Department;
import com.jet.pis.service.DepartmentService;

@RestController
@RequestMapping("/jet/pis/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	//API to create the departments
	@PostMapping
	public ResponseEntity<Department> createDepartment(@RequestBody Department department){
		return new ResponseEntity<Department>(departmentService.createDepartment(department), HttpStatus.CREATED);
	}
	
	//API to get all departments
	@GetMapping
	public List<Department> getAllDepartment(){
		return departmentService.getAllDepartments();
	}
	
	//API to get department by its id
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Department>> getDepartmentById(@PathVariable("id") long id){
		return new ResponseEntity<Optional<Department>>(departmentService.getDepartmentsById(id), HttpStatus.OK);
	}
	//API to update a particular department
	@PutMapping("/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable("id") long id ,@RequestBody Department department){
		return new ResponseEntity<Department>(departmentService.updateDepartment(department, id), HttpStatus.OK);
	}
	
	//API to delete a particular department
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable("id") long id){
		System.out.println("hellooo");
		// delete department from DB
		departmentService.deleteDepartment(id);
		return new ResponseEntity<String>("Department deleted successfully!.", HttpStatus.OK);
	}
	
	
	

}
