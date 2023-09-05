package io.nology.employeecreator.employer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.nology.employeecreator.exceptions.NotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("employers")
public class EmployerController {
	
	@Autowired
	private EmployerService service;

	@PostMapping
	public ResponseEntity<Employer> create(@Valid @RequestBody CreateEmployerDTO data){
		Employer createdEmployer = this.service.create(data);
		return new ResponseEntity<>(createdEmployer, HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Employer>> getAll() {
		List<Employer> allEmployers = this.service.findAll();
		return new ResponseEntity<>(allEmployers, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employer> getById(@PathVariable Long id) {
		Optional<Employer> foundEmployer = this.service.findById(id);
		
		return new ResponseEntity<>(foundEmployer.get(), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Employer> deleteById(@PathVariable Long id) {
		boolean deleted = this.service.delete(id);
		
		if(!deleted) {
			throw new NotFoundException(String.format(
					"Post with id: %s not found, could not delete.", 
					id));
		}
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	} 
}
