package com.proje.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String firstName;
	
	private String lastName;

	private Date birthDate;
	
	@ElementCollection
	@CollectionTable(name = "user_adress", joinColumns = @JoinColumn(name = "userId"))
	@AttributeOverrides({ // Embeddable olduğu için bu yapılabiliyor
		@AttributeOverride(name = "street", column = @Column(name = "Sokak", length = 50)),
		@AttributeOverride(name = "district", column = @Column(name = "Bölge", length = 50)),
		@AttributeOverride(name = "city", column = @Column(name = "Sehir", length = 50)),
		@AttributeOverride(name = "postalCode", column = @Column(name = "PostaKodu", length = 50))
	}) 
	private List<Adress> adresses = new ArrayList<>();
	
	public User() {}

	public User(String firstName, String lastName, Date birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}
	
	public void addAdress(Adress adress) {
		this.adresses.add(adress);
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

	public List<Adress> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adress> adresses) {
		this.adresses = adresses;
	}

	@Override
	public String toString() {
		return "User2 [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", adresses=" + adresses + "]";
	}

}
