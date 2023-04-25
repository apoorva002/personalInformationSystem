package com.jet.pis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jet.pis.model.Designation;


@Repository
public interface DesignationRepository extends JpaRepository<Designation,Long> {

}
