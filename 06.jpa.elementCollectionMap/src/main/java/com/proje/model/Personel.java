package com.proje.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.proje.util.PhoneType;

@Entity
@Table(name = "personel")
public class Personel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String firstName;
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@ElementCollection //(fetch = FetchType.LAZY, EAGER)
	@CollectionTable(name = "personel_phoneNumber", joinColumns = @JoinColumn(name = "personelId"))
	@MapKeyColumn(name = "phoneType")
	@MapKeyEnumerated(EnumType.STRING)
	@Column(name = "phoneNumber")
	private Map<PhoneType, String> phoneNumbers = new HashMap<PhoneType, String>();
	
	public Personel() {}
	
	
	public Personel(String firstName, String lastName, Date birthDate) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}
	
	public void addAdress(PhoneType phoneType, String phoneNumber) {
		this.phoneNumbers.put(phoneType, phoneNumber);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public Map<PhoneType, String> getPhoneNumbers() {
		return phoneNumbers;
	}

	@Override
	public String toString() {
		return "Personel [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", phoneNumbers=" + phoneNumbers + "]";
	}
	
	
	
}
