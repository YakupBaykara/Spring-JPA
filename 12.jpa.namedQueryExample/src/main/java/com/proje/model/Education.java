package com.proje.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "Education.findEducations", query = "SELECT e FROM Education e"),
	@NamedQuery(name = "Education.finById", query = "SELECT e FROM Education e WHERE e.id = :id"),
	@NamedQuery(name = "Education.findWithAdvertisementById", query = "SELECT e FROM Education e LEFT JOIN FETCH e.advertisements WHERE e.id = :id"),
})
public class Education implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String educationName;
	
	private int lisansYear;
	
	@ManyToMany(mappedBy = "educations")
	private List<Advertisement> advertisements = new ArrayList<Advertisement>();
	
	public Education() {}

	public Education(String educationName, int lisansYear) {
		super();
		this.educationName = educationName;
		this.lisansYear = lisansYear;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEducationName() {
		return educationName;
	}

	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}

	public int getLisansYear() {
		return lisansYear;
	}

	public void setLisansYear(int lisansYear) {
		this.lisansYear = lisansYear;
	}

	public List<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(List<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}
	
}
