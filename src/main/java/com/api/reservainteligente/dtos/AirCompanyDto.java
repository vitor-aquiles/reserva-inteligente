package com.api.reservainteligente.dtos;

import javax.validation.constraints.NotBlank;

import com.api.reservainteligente.entities.AirCompany;

public class AirCompanyDto {

	private Long id;
	
	@NotBlank(message = "Name cannot be blank.")
	private String companyName;
	
	@NotBlank(message = "CNPJ cannot be blank.")
	private String cnpj;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public static AirCompanyDto getInstance(AirCompany airCompany) {
		AirCompanyDto airCompanyDto = new AirCompanyDto();
		airCompanyDto.setId(airCompany.getId());
		airCompanyDto.setCompanyName(airCompany.getCompanyName());
		airCompanyDto.setCnpj(airCompany.getCnpj());		
		return airCompanyDto;
	}
	
	@Override
	public String toString() {
		return "AirCompanyDto [id=" + id + ", companyName=" + companyName + ", cnpj=" + cnpj + "]";
	}
	
}
