package io.nology.employeecreator.employer;


import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employer extends RepresentationModel<Employer> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String email;
	
	@Column
	private Long number;
	
	@Column
	private String address;
	
	@Column
	private String contractType;
	
	@Column
	private String startDate;
	
	@Column
	private String finishDate;
	
	@Column
	private Boolean isFulltime;
	
	public Employer() {}
	
	public Employer(String firstName, String lastName, String email, Long number, String address, String contractType, String startDate, String finishDate, Boolean isFulltime) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.number = number;
		this.address = address;
		this.contractType = contractType;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.isFulltime = isFulltime;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}

	public Boolean getIsFulltime() {
		return isFulltime;
	}

	public void setIsFulltime(Boolean isFulltime) {
		this.isFulltime = isFulltime;
	}
	
	
}
