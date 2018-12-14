package com.api.reservainteligente.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "airport")
public class Airport implements Serializable{

	private static final long serialVersionUID = 8779803065636600895L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "city", nullable = false)
	private String city;
	
	@Column(name = "state", nullable = false)
	private String state;
	
	@OneToMany(mappedBy = "airport", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Flight> flights;

	public Airport() {
	
	}
	
	public Airport(Long id, String name, String city, String state, List<Flight> flights) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.state = state;
		this.flights = flights;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	@Override
	public String toString() {
		return "Airport [id=" + id + ", name=" + name + ", city=" + city + ", state=" + state + ", flights=" + flights
				+ "]";
	}
}
