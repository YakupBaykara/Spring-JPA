package com.proje.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	@NamedQuery(name = "User.findById", query = "SELECT u FROM User u LEFT JOIN FETCH u.userDetail WHERE u.id = :id"), // FETCH eklenerek bu sorgu için (Id ile arama) gelmesini belirtiyoruz.
	@NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
	@NamedQuery(name = "User.findWithUserDetailByUsername", query = "SELECT u FROM User u LEFT JOIN FETCH u.userDetail WHERE u.username = :username"),
	@NamedQuery(name = "User.findAllUsers", query = "SELECT u FROM User u"),
	@NamedQuery(name = "User.findCount", query = "SELECT COUNT(u) FROM User u"),
	@NamedQuery(name = "User.findWithUserInfoByUsername", query = "SELECT new com.proje.model.UserInfo(u.username, u.userDetail.firstName, u.userDetail.lastName, u.userDetail.birthDate)"
			+ "FROM User u WHERE u.username = :username"),
	
})
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String username, password;
	
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private UserDetail userDetail;
	
	public User() {}

	public User(String username, String password, Date creationDate) {
		super();
		this.username = username;
		this.password = password;
		this.creationDate = creationDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

}
