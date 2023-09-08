package io.nology.employeecreator.employer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
		
		createdEmployer.add(linkTo(EmployerController.class).slash(createdEmployer.getId()).withSelfRel());
		
		return new ResponseEntity<>(createdEmployer, HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Employer>> getAll() {
		List<Employer> allEmployers = this.service.findAll();
		
		allEmployers
			.stream()
			.forEach(e -> e.add(linkTo(EmployerController.class).slash(e.getId()).withSelfRel()));
		
		return new ResponseEntity<>(allEmployers, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employer> getById(@PathVariable Long id) {
		Optional<Employer> maybeEmployer = this.service.findById(id);
		
		if(maybeEmployer.isEmpty()) {
			throw new NotFoundException(String.format("Employee with id: %s not found", id));
		}
		
		Employer foundEmployer = maybeEmployer.get();
		
		foundEmployer.add(linkTo(EmployerController.class).slash(foundEmployer.getId()).withSelfRel());
		
		return new ResponseEntity<>(foundEmployer, HttpStatus.OK);
		
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Employer> updateById(@PathVariable Long id,
			@Valid @RequestBody UpdateEmployerDTO data) {
		Optional<Employer> maybeUpdated = this.service.update(id, data);
		if(maybeUpdated.isEmpty()) {
			throw new NotFoundException(String.format(
					"Employee with id: %s not found, could not update", 
					id));
		}
		
		Employer updatedEmployer = maybeUpdated.get();
		updatedEmployer.add(linkTo(EmployerController.class).slash(updatedEmployer.getId()).withSelfRel());
		
		return new ResponseEntity<Employer>(updatedEmployer, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Employer> deleteById(@PathVariable Long id) {
		boolean deleted = this.service.delete(id);
		
		if(!deleted) {
			throw new NotFoundException(String.format(
					"Employee with id: %s not found, could not delete.", 
					id));
		}
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	} 
}
