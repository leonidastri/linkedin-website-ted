package model;

import java.io.Serializable;
import javax.persistence.*;

/* for xml marshalling */
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;


/**
 * The persistent class for the like_listing database table.
 * 
 */

@XmlRootElement // for xml marshalling
@Entity
@Table(name="like_listing")
@NamedQuery(name="LikeListing.findAll", query="SELECT l FROM LikeListing l")
public class LikeListing implements Serializable {
	private static final long serialVersionUID = 1L;

	@XmlAttribute
	@Id
	private String like_listingID;

	@XmlElement(name="listing")
	//bi-directional many-to-one association to Listing
	@ManyToOne
	@JoinColumn(name="listingID")
	private Listing listing;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userID")
	private User user;

	public LikeListing() {
	}

	public String getLike_listingID() {
		return this.like_listingID;
	}

	public void setLike_listingID(String like_listingID) {
		this.like_listingID = like_listingID;
	}

	public Listing getListing() {
		return this.listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}