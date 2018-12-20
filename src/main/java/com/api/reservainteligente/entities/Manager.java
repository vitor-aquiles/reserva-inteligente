package com.api.reservainteligente.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.api.reservainteligente.dtos.ManagerDto;
import com.api.reservainteligente.enums.ProfileEnum;

@Entity
@Table(name = "manager")
public class Manager implements Serializable{

	private static final long serialVersionUID = -2030406248745593718L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "profile", nullable = false)
	private ProfileEnum profile;
	
	@OneToOne(fetch = FetchType.EAGER, optional = false)
	private AirCompany airCompany;

	@Column(name = "register_date", nullable = false)
	private Date registerDate;

	@Column(name = "update_date", nullable = false)
	private Date updateDate;
	
	public Manager() {
	}

	public Manager(
			Long id, 
			String name, 
			String email, 
			String password, 
			String cpf, 
			ProfileEnum profile,
			AirCompany airCompany, 
			Date registerDate, 
			Date updateDate) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.cpf = cpf;
		this.profile = profile;
		this.airCompany = airCompany;
		this.registerDate = registerDate;
		this.updateDate = updateDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	
	public AirCompany getAirCompany() {
		return airCompany;
	}

	public void setAirCompany(AirCompany airCompany) {
		this.airCompany = airCompany;
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
	
	@PrePersist
	public void PrePersist() {
		final Date actualDate = new Date();
		registerDate = actualDate;
		updateDate = actualDate;
	}
	
	@PreUpdate
	public void PreUpdate() {
		updateDate = new Date();
	}
	
	/** Retorna um Manager a partir de um DTO
	 * 
	 * @param manager
	 * @return managerDto
	 */
	public static Manager getInstance(ManagerDto managerDto) {
		Manager manager = new Manager();
		manager.setId(managerDto.getId()); 
		manager.setName(managerDto.getName());
		manager.setCpf(managerDto.getCpf());
		manager.setEmail(managerDto.getEmail());
		manager.setPassword(managerDto.getPassword());
		manager.setProfile(managerDto.getProfile());
		manager.setAirCompany(new AirCompany());
		manager.getAirCompany().setId(managerDto.getIdAirCompany());
		return manager;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", cpf=" + cpf
				+ ", profile=" + profile + ", airCompany=" + airCompany + ", registerDate=" + registerDate
				+ ", updateDate=" + updateDate + "]";
	}

	
	
}
