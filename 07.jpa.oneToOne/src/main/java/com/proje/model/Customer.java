package com.proje.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String firstName;
	
	private String lastName;

	private Date birthDate;
	
	// @OneToOne(cascade = CascadeType.PERSIST) => Test sınıfında customer a adress eklenince sadece customer persist edilir. Beraber kaydedilirler.
	// @OneToOne(cascade = CascadeType.REMOVE) => Customer silinince adreste silinir.
	// @OneToOne(cascade = CascadeType.MERGE) => Customer güncellenince adreste güncellenir.
	// @OneToOne(cascade = CascadeType.ALL) => Customer da yapılan tüm işlemlerde adres tablosu da etkilenir.
	// @OneToOne(cascade = CascadeType.ALL, targetEntity ="Adress.class") olarak belirtilebilir.
	@OneToOne
	@JoinColumn(name = "adressId")
	private Adress adress;

	public Customer() {}

	public Customer(String firstName, String lastName, Date birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
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

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", adress=" + adress + "]";
	}

}
