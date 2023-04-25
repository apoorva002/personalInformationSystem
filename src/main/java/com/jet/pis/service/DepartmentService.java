package com.jet.pis.service;

import java.util.List;
import java.util.Optional;

import com.jet.pis.model.Department;

public interface DepartmentService {
	
	 public Department createDepartment(Department department);
	   public List<Department> getAllDepartments();
	   public Optional<Department> getDepartmentsById(long id);
	   public Department updateDepartment(Department department, long id);
	   public void deleteDepartment(long id);

}
