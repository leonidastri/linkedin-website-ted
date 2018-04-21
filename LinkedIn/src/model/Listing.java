package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the listing database table.
 * 
 */
@Entity
@Table(name="listing")
@NamedQuery(name="Listing.findAll", query="SELECT l FROM Listing l")
public class Listing implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String listingID;

	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="pub_date")
	private Date pubDate;

	private String title;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="listings1")
	private List<User> users;

	//bi-directional many-to-one association to User
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

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}