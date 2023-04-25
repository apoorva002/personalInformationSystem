package com.jet.pis.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jet.pis.exception.ResourceNotFoundException;
import com.jet.pis.model.Department;
import com.jet.pis.model.Designation;
import com.jet.pis.repository.DesignationRepository;
import com.jet.pis.service.DesignationService;

@Service
public class DesignationServiceImpl implements DesignationService {
	
     @Autowired
	 private DesignationRepository designationRepositroy;
	
	@Override
	public List<Designation> getAllDesignation() {
		return designationRepositroy.findAll();
	}

	@Override
	public Designation createDesignation(Designation designation) {
		return designationRepositroy.save(designation) ;
	}

	@Override
	public Optional<Designation> getDesignationById(long id) {
		
		return designationRepositroy.findById(id) ;
	}

	@Override
	public Designation updateDesignation(Designation designation, long id) {
		Designation existingDesignation = designationRepositroy.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Designation", "Id", id));
		existingDesignation.setName(designation.getName());
		return designationRepositroy.save(existingDesignation);
	}

	@Override
	public void deleteDesignation(long id) {
		designationRepositroy.findById(id).orElseThrow(() -> new ResourceNotFoundException("ResourcePermission", "Id", id));
		designationRepositroy.deleteById(id);
		
	}

}
