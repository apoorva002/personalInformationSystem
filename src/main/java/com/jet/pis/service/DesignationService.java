package com.jet.pis.service;

import java.util.List;
import java.util.Optional;
import com.jet.pis.model.Designation;

public interface DesignationService {
	
	public List<Designation> getAllDesignation(); 
	public Designation createDesignation(Designation designation);
	public Optional<Designation> getDesignationById(long id);
	public Designation updateDesignation(Designation designation, long id);
	public void deleteDesignation(long id);

}
