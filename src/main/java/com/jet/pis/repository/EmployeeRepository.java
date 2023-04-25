package com.jet.pis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jet.pis.model.Employee;

public interface EmployeeRepository extends JpaRepository <Employee,Long>{

}
