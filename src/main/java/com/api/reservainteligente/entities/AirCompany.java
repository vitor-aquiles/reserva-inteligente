package com.api.reservainteligente.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "airline")
public class AirCompany implements Serializable{

	private static final long serialVersionUID = 8902680534215815040L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "company_name", nullable = false)
	private String companyName;
	
	@Column(name = "cnpj", nullable = false)
	private String cnpj;
	
	@OneToOne
	private Manager manager;
	
	@OneToMany
	private List<Flight> flights;
	
	@Column(name = "register_date", nullable = false)
	private Date registerDate;

	@Column(name = "update_date", nullable = false)
	private Date updateDate;

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

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
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

	@Override
	public String toString() {
		return "Airline [id=" + id + ", companyName=" + companyName + ", cnpj=" + cnpj + ", manager=" + manager
				+ ", registerDate=" + registerDate + ", updateDate=" + updateDate + "]";
	}
}
