package io.nology.employeecreator.employer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateEmployerDTO {

	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	private String email;
	
	@NotNull
	private Long number;
	
	@NotBlank
	private String address;
	
	@NotBlank
	private String contractType;
	
	@NotNull
	private String startDate;
	
	
	private String finishDate;
	
	@NotNull
	private Boolean isFulltime;

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
