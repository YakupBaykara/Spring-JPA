package com.proje.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.proje.util.PhoneType;

@Entity
@NamedQueries({
	@NamedQuery(name = "UserDetail.findById", query = "SELECT ud FROm UserDetail ud WHERE ud.id = :id"),
	@NamedQuery(name = "UserDetail.findByUsername", query = "SELECT ud FROM UserDetail ud WHERE ud.user.username = :username"),
																					  // LEFT JOIN ud.user u WHERE u.username = :username
	@NamedQuery(name = "UserDetail.findWithAddressByUsername", query = "SELECT ud FROM UserDetail ud LEFT JOIN FETCH ud.addresses "
			+ "WHERE ud.user.username = :username"),
	@NamedQuery(name = "UserDetail.findWithAdvertisementsByUsername", query = "SELECT ud FROM UserDetail ud LEFT JOIN FETCH ud.advertisements "
			+ "WHERE ud.user.username = :username")
})
public class UserDetail implements Serializable{

	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String firstName, lastName;
	
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	
	@ElementCollection
	@JoinTable(name = "userDetail_phoneNumber",  joinColumns = @JoinColumn(name = "userDetailId")) // primary key kolonu
	@MapKeyColumn(name = "phoneType")  // map key kolonu
	@MapKeyEnumerated(EnumType.STRING)
	@Column(name = "phoneNumber")  // map value kolonu
	private Map<PhoneType, String> phoneNumbers = new HashMap<PhoneType, String>();
	
	@ElementCollection(fetch = FetchType.LAZY)
	@JoinTable(name = "userDetail_adress", joinColumns = @JoinColumn(name ="userDetailId"))
	private List<Address> addresses = new ArrayList<Address>();
	
	@OneToOne(mappedBy = "userDetail", fetch = FetchType.LAZY)
	private User user;
	
	@OneToMany(mappedBy = "userDetail", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}) // Many ile bittiği için FetchType otomatik olarak LAZY' dir.
	private List<Advertisement> advertisements = new ArrayList<Advertisement>();
	
	public UserDetail() {}

	public UserDetail(String firstName, String lastName, Date birthDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public void setPhoneNumbers(Map<PhoneType, String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAdresses(List<Address> adresses) {
		this.addresses = adresses;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(List<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}

	@Override
	public String toString() {
		return "UserDetail [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate="
				+ birthDate + ", phoneNumbers=" + phoneNumbers + ", adresses=" + addresses + ", user=" + user
				+ ", advertisements=" + advertisements + "]";
	}
	
}
