package com.api.reservainteligente.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.api.reservainteligente.dtos.ManagerDto;
import com.api.reservainteligente.enums.ProfileEnum;

@Entity
@Table(name = "manager")
public class Manager implements Serializable{

	private static final long serialVersionUID = -2030406248745593718L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@Column(name = "profile", nullable = false)
	private ProfileEnum profile;

	@Column(name = "register_date", nullable = false)
	private Date registerDate;

	@Column(name = "update_date", nullable = false)
	private Date updateDate;
	
	public Manager() {
	}
	
	public Manager(
			Integer id, 
			String name, 
			String email, 
			String password, 
			String cpf, 
			ProfileEnum profile,
			Date registerDate, 
			Date updateDate) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.cpf = cpf;
		this.profile = profile;
		this.registerDate = registerDate;
		this.updateDate = updateDate;
	}

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
	
	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	public void PrePersist() {
		final Date actualDate = new Date();
		registerDate = actualDate;
		updateDate = actualDate;
	}
	
	public void PreUpdate() {
		updateDate = new Date();
	}
	
	/** Retorna um Manager a partir de um DTO
	 * 
	 * @param manager
	 * @return managerDto
	 */
	public static Manager getInstace(ManagerDto managerDto) {
		Manager manager = new Manager();
		manager.setId(managerDto.getId());
		manager.setName(managerDto.getName());
		manager.setCpf(managerDto.getCpf());
		manager.setEmail(managerDto.getEmail());
		manager.setPassword(managerDto.getPassword());
		manager.setProfile(managerDto.getProfile());
		return manager;
	}
}
