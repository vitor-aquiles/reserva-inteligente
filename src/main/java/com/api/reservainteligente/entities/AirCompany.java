package com.api.reservainteligente.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.api.reservainteligente.dtos.AirCompanyDto;

@Entity
@Table(name = "aircompany")
public class AirCompany implements Serializable{

	private static final long serialVersionUID = 8902680534215815040L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "company_name", nullable = false)
	private String companyName;
	
	@Column(name = "cnpj", nullable = false)
	private String cnpj;
	
	@OneToOne(mappedBy = "airCompany")//, optional = true
	private Manager manager;
	
	@OneToMany(mappedBy = "airCompany", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Flight> flights;
	
	@Column(name = "register_date", nullable = false)
	private Date registerDate;

	@Column(name = "update_date", nullable = false)
	private Date updateDate;

	public AirCompany() {
	
	}
	
	public AirCompany(Long id, String companyName, String cnpj, Manager manager, List<Flight> flights,
			Date registerDate, Date updateDate) {
		this.id = id;
		this.companyName = companyName;
		this.cnpj = cnpj;
		this.manager = manager;
		this.flights = flights;
		this.registerDate = registerDate;
		this.updateDate = updateDate;
	}

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
	
	public static AirCompany getInstance(AirCompanyDto airCompanyDto) {
		AirCompany airCompany = new AirCompany();
		airCompany.setId(airCompanyDto.getId());
		airCompany.setCompanyName(airCompanyDto.getCompanyName());
		airCompany.setCnpj(airCompanyDto.getCnpj());
		return airCompany;
	}

	@Override
	public String toString() {
		return "AirCompany [id=" + id + ", companyName=" + companyName + ", cnpj=" + cnpj + ", manager=" + manager
				+ ", flights=" + flights + ", registerDate=" + registerDate + ", updateDate=" + updateDate + "]";
	}
	
	
}
