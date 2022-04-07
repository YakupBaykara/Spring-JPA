package com.proje.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "Advertisement.findById", query = "SELECT a FROM Advertisement a LEFT JOIN FETCH a.educations WHERE a.id = :id"),
	@NamedQuery(name = "Advertisement.findByUsername", query = "SELECT a FROM User u LEFT JOIN u.userDetail ud LEFT JOIN ud.advertisements a "
			+ "WHERE u.username = :username"),
	@NamedQuery(name = "Advertisement.findAdvertisements", query = "SELECT a FROM Advertisement a")
})
public class Advertisement implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String title;
	
	@Lob
	private String criteria;
	
	private Date addDate;
	
	private Date updateDate = new Date();
	
	private Date removeDate;
	
	@Lob
	private String workDefinition;
	
	private Boolean enabled;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = UserDetail.class)
	@JoinColumn(name = "departmentId")
	private UserDetail userDetail;
	
	@ManyToMany
	@JoinTable(name = "advertisement_education",  joinColumns = @JoinColumn(name = "advertisementId"), inverseJoinColumns = @JoinColumn(name = "educationId"))
	private List<Education> educations = new ArrayList<Education>();

	public Advertisement() {}

	public Advertisement(String title, String criteria, String workDefinition) {
		super();
		this.title = title;
		this.criteria = criteria;
		this.workDefinition = workDefinition;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getRemoveDate() {
		return removeDate;
	}

	public void setRemoveDate(Date removeDate) {
		this.removeDate = removeDate;
	}

	public String getWorkDefinition() {
		return workDefinition;
	}

	public void setWorkDefinition(String workDefinition) {
		this.workDefinition = workDefinition;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public List<Education> getEducations() {
		return educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	
}
