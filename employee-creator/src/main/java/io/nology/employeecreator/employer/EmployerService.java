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
	
	public boolean delete(Long id) {
		Optional<Employer> e = repository.findById(id);
		
		if(e.isEmpty()) {
			return false;
		}
		
		repository.deleteById(id);
		return true;
	}
}
