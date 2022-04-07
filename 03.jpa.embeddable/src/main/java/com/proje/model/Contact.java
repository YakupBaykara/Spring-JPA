package com.proje.model;

import javax.persistence.Embeddable;

@Embeddable
public class Contact {

	private String phoneNumber;
	private String email;
	private String link;
	
	public Contact() {}

	public Contact(String phoneNumber, String email, String link) {
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.link = link;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
