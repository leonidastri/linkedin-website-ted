package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/* for xml marshalling */
//import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;


/**
 * The persistent class for the listing database table.
 * 
 */

//@XmlRootElement // for xml marshalling
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="listing")
@NamedQuery(name="Listing.findAll", query="SELECT l FROM Listing l")
public class Listing implements Serializable {
	private static final long serialVersionUID = 1L;

	@XmlAttribute // for xml marshalling
	@XmlID
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String listingID;

	@XmlElement // for xml marshalling
	private String description;

	@XmlElement(name="publicationDate") // for xml marshalling
	@Temporal(TemporalType.DATE)
	@Column(name="pub_date")
	private Date pubDate;

	@XmlElement // for xml marshalling
	private String title;

	//bi-directional many-to-one association to LikeListing
	@OneToMany(mappedBy="listing")
	private List<LikeListing> likeListings;

	//bi-directional many-to-one association to User
	@XmlTransient
	@ManyToOne
	@JoinColumn(name="userID")
	private User user;

	public Listing() {
	}

	public String getListingID() {
		return this.listingID;
	}

	public void setListingID(String listingID) {
		this.listingID = listingID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPubDate() {
		return this.pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<LikeListing> getLikeListings() {
		return this.likeListings;
	}

	public void setLikeListings(List<LikeListing> likeListings) {
		this.likeListings = likeListings;
	}

	public LikeListing addLikeListing(LikeListing likeListing) {
		getLikeListings().add(likeListing);
		likeListing.setListing(this);

		return likeListing;
	}

	public LikeListing removeLikeListing(LikeListing likeListing) {
		getLikeListings().remove(likeListing);
		likeListing.setListing(null);

		return likeListing;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}