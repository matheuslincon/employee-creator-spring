package io.nology.employeecreator.employer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployerService {
	
	@Autowired
	private EmployerRepository repository;

	public Employer create(CreateEmployerDTO data) {
		
		Employer employer = new Employer(data.getFirstName(), data.getLastName(), data.getEmail(), data.getNumber(), data.getAddress(), data.getContractType(), data.getStartDate(), data.getFinishDate(), data.getIsFulltime());
		repository.save(employer);
		return employer;
		
	}
	
	public List<Employer> findAll(){
		return repository.findAll();
	}
	
	public Optional<Employer> findById(Long id) {
		return repository.findById(id);
	}
	
	public Optional<Employer> update(Long id, UpdateEmployerDTO data) {
		
		Optional<Employer> maybeEmployer = repository.findById(id);
		
//		employer.ifPresent(employerMaybe -> {
//			employerMaybe.setFirstname(data.getFirstname());
//			employerMaybe.setLastname(data.getLastname());
//			employerMaybe.setEmail(data.getEmail());
//			employerMaybe.setNumber(data.getNumber());
//			employerMaybe.setAddress(data.getAddress());
//			employerMaybe.setIspermanent(data.getIspermanent());
//			employerMaybe.setStartdate(data.getStartdate());
//			employerMaybe.setFinishdate(data.getFinishdate());
//		});
		
		if(maybeEmployer.isPresent()) {
			Employer existingEmployer = maybeEmployer.get();
			
			existingEmployer.setFirstName(data.getFirstName());
			existingEmployer.setLastName(data.getLastName());
			existingEmployer.setEmail(data.getEmail());
			existingEmployer.setNumber(data.getNumber());
			existingEmployer.setAddress(data.getAddress());
			existingEmployer.setContractType(data.getContractType());
			existingEmployer.setStartDate(data.getStartDate());
			existingEmployer.setFinishDate(data.getFinishDate());
			existingEmployer.setIsFulltime(data.getIsFulltime());
			
			return Optional.of(repository.save(existingEmployer));
		}
		return maybeEmployer;
	}
	
	public boolean delete(Long id) {
		Optional<Employer> e = repository.findById(id);
		
		if(e.isEmpty()) {
			return false;
		}
		
		repository.deleteById(id);
		return true;
	}
}
