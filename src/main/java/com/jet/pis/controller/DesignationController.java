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
import com.jet.pis.model.Designation;
import com.jet.pis.service.DesignationService;

@RestController
@RequestMapping("/jet/pis/designation")
public class DesignationController {
	
	@Autowired
	private DesignationService designationService;
	
	//API to create designation
	@PostMapping
	public ResponseEntity<Designation> createAddress(@RequestBody Designation designation){
		return new ResponseEntity<Designation>(designationService.createDesignation(designation), HttpStatus.CREATED);
	}
	
	//API to get all designation
	@GetMapping
	public List<Designation> getAllDesignation(){
		return designationService.getAllDesignation();
	}
	
	//API to get designation by id
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Designation>> getDesignationById(@PathVariable("id") long id){
		return new ResponseEntity<Optional<Designation>>(designationService.getDesignationById(id), HttpStatus.OK);
	}
	//API to update designation
	@PutMapping("/{id}")
	public ResponseEntity<Designation> updateDesignation(@PathVariable("id") long id ,@RequestBody Designation designation){
		return new ResponseEntity<Designation>(designationService.updateDesignation(designation, id), HttpStatus.OK);
	}
	//API to delete designation
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDesignation(@PathVariable("id") long id){
		// delete department from DB
		designationService.deleteDesignation(id);
		return new ResponseEntity<String>("deleted successfully!.", HttpStatus.OK);
	}

}
