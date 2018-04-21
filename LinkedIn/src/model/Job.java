package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the job database table.
 * 
 */
@Entity
@Table(name="job")
@NamedQuery(name="Job.findAll", query="SELECT j FROM Job j")
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String userID;

	@Column(name="job_description")
	private String jobDescription;

	@Temporal(TemporalType.DATE)
	@Column(name="job_from")
	private Date jobFrom;

	@Column(name="job_title")
	private String jobTitle;

	@Temporal(TemporalType.DATE)
	@Column(name="job_to")
	private Date jobTo;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="userID")
	private User user;

	public Job() {
	}

	public String getUserID() {
		return this.userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getJobDescription() {
		return this.jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public Date getJobFrom() {
		return this.jobFrom;
	}

	public void setJobFrom(Date jobFrom) {
		this.jobFrom = jobFrom;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Date getJobTo() {
		return this.jobTo;
	}

	public void setJobTo(Date jobTo) {
		this.jobTo = jobTo;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}