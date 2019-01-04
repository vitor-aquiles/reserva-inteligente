package com.api.reservainteligente.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String country;
	private String street;
	private String number;
	private String zipCode;
	
	public Address(String country, String street, String number, String zipCode) {
		this.country = country;
		this.street = street;
		this.number = number;
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Address [country=" + country + ", street=" + street + ", number=" + number + ", zipCode=" + zipCode
				+ "]";
	}
}
