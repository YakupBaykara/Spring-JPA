package com.proje.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adres")
public class Adress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// OnetoOne ile adress tablosuna customer_id eklenir. 2 tabloda da ilişkili olduğu tablonun id si eklenir.
	//	Mappedby ekleyerek ilişki sahbinin customer olduğu belirtilir ve adress tablosunda customer_id yer almaz
	@OneToOne(mappedBy = "adress")
	private Customer customer;
	
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Adress [id=" + id + ", street=" + street + ", district=" + district + ", city=" + city + ", postalCode="
				+ postalCode + "]";
	}	
}
