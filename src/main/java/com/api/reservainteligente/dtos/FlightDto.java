package com.api.reservainteligente.dtos;

import java.text.ParseException;

import javax.validation.constraints.NotBlank;

import com.api.reservainteligente.entities.Flight;

public class FlightDto {

	private Long id;
	
	@NotBlank(message = "City Destination cannot be blank.")
	private String cityDestination;

	@NotBlank(message = "State Destination cannot be blank.")
	private String stateDestination;
	
	@NotBlank(message = "Departure Time cannot be blank.")
	private String departureTime;
	
	@NotBlank(message = "Arrival Time cannot be blank.")
	private String arrivalTime;
	
	@NotBlank(message = "Id Air Company cannot be blank.")
	private Long idAirCompany;
	
	@NotBlank(message = "Id Airport cannot be blank.")
	private Long IdAirport;

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

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Long getIdAirCompany() {
		return idAirCompany;
	}

	public void setIdAirCompany(Long idAirCompany) {
		this.idAirCompany = idAirCompany;
	}

	public Long getIdAirport() {
		return IdAirport;
	}

	public void setIdAirport(Long idAirport) {
		IdAirport = idAirport;
	}
	
	public static FlightDto getInstance(Flight flight) throws ParseException {
		FlightDto flightDto = new FlightDto();
		flightDto.setId(flight.getId());
		flightDto.setCityDestination(flight.getCityDestination());
		flightDto.setStateDestination(flight.getStateDestination());
		flightDto.setDepartureTime(String.valueOf(flight.getDepartureTime()));
		flightDto.setArrivalTime(String.valueOf(flight.getArrivalTime()));
		flightDto.setIdAirCompany(flight.getAirCompany().getId());
		flightDto.setIdAirport(flight.getAirport().getId());
		return flightDto;
	}

	@Override
	public String toString() {
		return "FlightDto [id=" + id + ", cityDestination=" + cityDestination + ", stateDestination=" + stateDestination
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", idAirCompany=" + idAirCompany
				+ ", IdAirport=" + IdAirport + "]";
	}
	
}
