package com.api.reservainteligente.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.api.reservainteligente.entities.Manager;
import com.api.reservainteligente.enums.ProfileEnum;

public class ManagerDto {

	private Integer id;
	
	@NotEmpty(message = "Nome não pode ser em branco.")
	@Length(min = 3, max = 200, message = "Nome deve conter de 3 a 200 caracteres.")
	private String name;
	
	@NotBlank(message = "Nome não pode ser em branco.")
	@Length(min = 5, max = 200, message = "Email deve conter de 5 a 200 caracteres.")
	@Email(message = "Email inválido.")
	private String email;
	
	@NotEmpty(message = "Senha não pode ser em branco.")
	private String password;
	
	@NotEmpty(message = "CPF não pode ser em branco.")
	@CPF(message = "CPF inválido.")
	private String cpf;
	
	private ProfileEnum profile;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public ProfileEnum getProfile() {
		return profile;
	}

	public void setProfile(ProfileEnum profile) {
		this.profile = profile;
	}

	/** Retorna um DTO com os dado de uma Manager
	 * 
	 * @param manager
	 * @return managerDto
	 */
	public static ManagerDto getInstace(Manager manager) {
		ManagerDto managerDto = new ManagerDto();
		managerDto.setId(manager.getId());
		managerDto.setName(manager.getName());
		managerDto.setCpf(manager.getCpf());
		managerDto.setEmail(manager.getEmail());
		managerDto.setPassword(manager.getPassword());
		managerDto.setProfile(manager.getProfile());
		return managerDto;
	}

	@Override
	public String toString() {
		return "ManagerDto [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", cpf="
				+ cpf + ", profile=" + profile + "]";
	}
	
	
}
