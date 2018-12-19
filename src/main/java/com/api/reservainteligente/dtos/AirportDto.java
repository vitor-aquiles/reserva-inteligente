package com.api.reservainteligente.dtos;

import javax.validation.constraints.NotBlank;

import com.api.reservainteligente.entities.Airport;

public class AirportDto {
	
	private Long id;

	@NotBlank(message = "Name cannot be blank.")
	private String name;
	
	@NotBlank(message = "City cannot be blank.")
	private String city;
	
	@NotBlank(message = "State cannot be blank.")
	private String state;

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
	
	public static AirportDto getInstance(Airport airport) {
		AirportDto airportDto = new AirportDto();
		airportDto.setId(airport.getId());
		airportDto.setName(airport.getName());
		airportDto.setCity(airport.getCity());
		airportDto.setState(airport.getState());
		return airportDto;
	}

	@Override
	public String toString() {
		return "AirportDto [id=" + id + ", name=" + name + ", city=" + city + ", state=" + state + "]";
	}
}
