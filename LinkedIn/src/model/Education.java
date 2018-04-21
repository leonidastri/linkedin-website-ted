package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the education database table.
 * 
 */
@Entity
@Table(name="education")
@NamedQuery(name="Education.findAll", query="SELECT e FROM Education e")
public class Education implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String userID;

	@Column(name="education_description")
	private String educationDescription;

	@Temporal(TemporalType.DATE)
	@Column(name="education_from")
	private Date educationFrom;

	@Column(name="education_title")
	private String educationTitle;

	@Temporal(TemporalType.DATE)
	@Column(name="education_to")
	private Date educationTo;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="userID")
	private User user;

	public Education() {
	}

	public String getUserID() {
		return this.userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getEducationDescription() {
		return this.educationDescription;
	}

	public void setEducationDescription(String educationDescription) {
		this.educationDescription = educationDescription;
	}

	public Date getEducationFrom() {
		return this.educationFrom;
	}

	public void setEducationFrom(Date educationFrom) {
		this.educationFrom = educationFrom;
	}

	public String getEducationTitle() {
		return this.educationTitle;
	}

	public void setEducationTitle(String educationTitle) {
		this.educationTitle = educationTitle;
	}

	public Date getEducationTo() {
		return this.educationTo;
	}

	public void setEducationTo(Date educationTo) {
		this.educationTo = educationTo;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}