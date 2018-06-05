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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String educationID;

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
	
	@Column(name="private")
	private Boolean priv;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userID")
	private User user;

	public Education() {
	}

	public String getEducationID() {
		return this.educationID;
	}

	public void setEducationID(String educationID) {
		this.educationID = educationID;
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
	
	public Boolean getPrivate() {
		return this.priv;
	}
	
	public void setPrivate(Boolean priv) {
		this.priv = priv;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}