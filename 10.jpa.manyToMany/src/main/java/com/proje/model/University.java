package com.proje.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "university")
public class University {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@ManyToMany(mappedBy = "universities")
	private List<Student> stundents;
	
	public University() {}

	public University(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStundents() {
		return stundents;
	}

	public void setStundents(List<Student> stundents) {
		this.stundents = stundents;
	}

	@Override
	public String toString() {
		return "University [id=" + id + ", name=" + name + ", stundents=" + stundents + "]";
	}
	
	
}
