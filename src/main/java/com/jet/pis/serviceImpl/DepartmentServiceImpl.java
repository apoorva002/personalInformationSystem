package com.jet.pis.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jet.pis.exception.ResourceNotFoundException;
import com.jet.pis.model.Department;
import com.jet.pis.repository.DepartmentRepository;
import com.jet.pis.service.DepartmentService;


@Service
public class DepartmentServiceImpl  implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department createDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> getAllDepartments() {
		
		return departmentRepository.findAll();
	}

	@Override
	public Optional<Department> getDepartmentsById(long id) {
		return departmentRepository.findById(id);
	}

	@Override
	public Department updateDepartment(Department department, long id) {
		Department existingDepartment = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department", "Id", id));
		existingDepartment.setName(department.getName());
		return departmentRepository.save(existingDepartment);
		
	}

	@Override
	public void deleteDepartment(long id) {
		departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ResourcePermission", "Id", id));
		departmentRepository.deleteById(id);
		
	}

	
}
