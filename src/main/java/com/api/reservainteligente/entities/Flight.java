package com.api.reservainteligente.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "flight")
public class Flight implements Serializable{

	private static final long serialVersionUID = -863441663052338411L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "city_destination", nullable = false)
	private String cityDestination;

	@Column(name = "state_destination", nullable = false)
	private String stateDestination;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "departure_time", nullable = false)
	private Date departureTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "arrival_time", nullable = false)
	private Date arrivalTime;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private AirCompany airCompany;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Airport airport;
	
	@Column(name = "register_date", nullable = false)
	private Date registerDate;

	@Column(name = "update_date", nullable = false)
	private Date updateDate;
	
	public Flight() {
	
	}
	
	public Flight(Long id, String cityDestination, String stateDestination, Date departureTime, Date arrivalTime,
			AirCompany airCompany, Airport airport, Date registerDate, Date updateDate) {
		this.id = id;
		this.cityDestination = cityDestination;
		this.stateDestination = stateDestination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.airCompany = airCompany;
		this.airport = airport;
		this.registerDate = registerDate;
		this.updateDate = updateDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCityDestination() {
		return cityDestination;
	}

	public void setCityDestination(String cityDestination) {
		this.cityDestination = cityDestination;
	}

	public String getStateDestination() {
		return stateDestination;
	}

	public void setStateDestination(String stateDestination) {
		this.stateDestination = stateDestination;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public AirCompany getAirCompany() {
		return airCompany;
	}

	public void setAirCompany(AirCompany airCompany) {
		this.airCompany = airCompany;
	}

	public Airport getAirpot() {
		return airport;
	}

	public void setAirpot(Airport airport) {
		this.airport = airport;
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
		return "Flight [id=" + id + ", cityDestination=" + cityDestination + ", stateDestination=" + stateDestination
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", airCompany=" + airCompany
				+ ", registerDate=" + registerDate + ", updateDate=" + updateDate + "]";
	}
}
