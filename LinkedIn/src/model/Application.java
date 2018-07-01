package model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the application database table.
 * 
 */
@Entity
@Table(name="application")
@NamedQuery(name="Application.findAll", query="SELECT a FROM Application a")
public class Application implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String applicationID;

	private Boolean accepted;

	private Boolean rejected;
	
	//bi-directional many-to-one association to User
	@XmlTransient
	@ManyToOne
	@JoinColumn(name="applicantID")
	private User user;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="listingID")
	private Listing listing;

	public Application() {
	}

	public String getApplicationID() {
		return this.applicationID;
	}

	public void setApplicationID(String applicationID) {
		this.applicationID = applicationID;
	}

	public Boolean getAccepted() {
		return this.accepted;
	}

	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Listing getListing() {
		return this.listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}

	public Boolean getRejected() {
		return this.rejected;
	}

	public void setRejected(Boolean rejected) {
		this.rejected = rejected;
	}

}