package com.proje.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String firstName, lastName;
	
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@ManyToMany //(mappedBy = "students") hata verdi
	@JoinTable(name = "student_university", joinColumns = @JoinColumn(name = "studentId"), inverseJoinColumns = @JoinColumn(name = "universityId"))
	private List<University> universities = new ArrayList<University>();

	public Student() {}
	
	public Student(String firstName, String lastName, Date birthDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}
	
	public void addUniversity(University university) {
		this.universities.add(university);
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
	
	
	public List<University> getUniversities() {
		return universities;
	}	

	public void setUniversities(List<University> universities) {
		this.universities = universities = new ArrayList<University>();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", universities=" + universities + "]";
	}
	
	
}
