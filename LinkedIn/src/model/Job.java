package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/* for xml marshalling */
//import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;


/**
 * The persistent class for the job database table.
 * 
 */

//@XmlRootElement // for xml marshalling
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="job")
@NamedQuery(name="Job.findAll", query="SELECT j FROM Job j")
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;

	@XmlAttribute // for xml marshalling
	@XmlID
	@Id
	private String jobID;

	@XmlElement // for xml marshalling
	@Column(name="job_description")
	private String jobDescription;

	@XmlElement(name="jobFromDate") // for xml marshalling
	@Temporal(TemporalType.DATE)
	@Column(name="job_from")
	private Date jobFrom;

	@XmlElement // for xml marshalling
	@Column(name="job_title")
	private String jobTitle;

	@XmlElement(name="jobToDate") // for xml marshalling
	@Temporal(TemporalType.DATE)
	@Column(name="job_to")
	private Date jobTo;
	
	@Column(name="private")
	private Boolean priv;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userID")
	private User user;

	public Job() {
	}

	public String getJobID() {
		return this.jobID;
	}

	public void setJobID(String jobID) {
		this.jobID = jobID;
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