package com.api.reservainteligente.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reservation implements Serializable{

	private static final long serialVersionUID = 1370207443267057641L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Passenger passenger;
	
	private Flight flight;
	
	private Date purchaseDate;

	public Reservation(Long id, Passenger passenger, Flight flight, Date purchaseDate) {
		super();
		this.id = id;
		this.passenger = passenger;
		this.flight = flight;
		this.purchaseDate = purchaseDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", passenger=" + passenger + ", flight=" + flight + ", purchaseDate="
				+ purchaseDate + "]";
	}
}
