package com.proje.model;

import javax.persistence.Embeddable;

@Embeddable
public class Adress {
	
	private String street;
	private String district;
	private String city;
	private int postalCode;
	
	public Adress() {}

	public Adress(String street, String district, String city, int postalCode) {
		super();
		this.street = street;
		this.district = district;
		this.city = city;
		this.postalCode = postalCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "Adress [street=" + street + ", district=" + district + ", city=" + city + ", postalCode=" + postalCode
				+ "]";
	}

}
