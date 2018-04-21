package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String userID;

	@Column(name="cv_path")
	private String cvPath;

	private String email;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="password_hashed")
	private String passwordHashed;

	@Column(name="phone_number")
	private String phoneNumber;

	@Column(name="photo_path")
	private String photoPath;

	//bi-directional many-to-one association to Article
	@OneToMany(mappedBy="user")
	private List<Article> articles1;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="user")
	private List<Comment> comments;

	//bi-directional many-to-many association to User
	@ManyToMany
	@JoinTable(
		name="connection"
		, joinColumns={
			@JoinColumn(name="userID_2")
			}
		, inverseJoinColumns={
			@JoinColumn(name="userID_1")
			}
		)
	private List<User> users1;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="users1")
	private List<User> users2;

	//bi-directional one-to-one association to Education
	@OneToOne(mappedBy="user")
	private Education education;

	//bi-directional one-to-one association to Job
	@OneToOne(mappedBy="user")
	private Job job;

	//bi-directional many-to-many association to Article
	@ManyToMany
	@JoinTable(
		name="like_article"
		, joinColumns={
			@JoinColumn(name="userID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="articleID")
			}
		)
	private List<Article> articles2;

	//bi-directional many-to-many association to Listing
	@ManyToMany
	@JoinTable(
		name="like_listing"
		, joinColumns={
			@JoinColumn(name="userID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="listingID")
			}
		)
	private List<Listing> listings1;

	//bi-directional many-to-one association to Listing
	@OneToMany(mappedBy="user")
	private List<Listing> listings2;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="user1")
	private List<Message> messages1;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="user2")
	private List<Message> messages2;

	//bi-directional one-to-one association to Skill
	@OneToOne(mappedBy="user")
	private Skill skill;

	public User() {
	}

	public String getUserID() {
		return this.userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getCvPath() {
		return this.cvPath;
	}

	public void setCvPath(String cvPath) {
		this.cvPath = cvPath;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPasswordHashed() {
		return this.passwordHashed;
	}

	public void setPasswordHashed(String passwordHashed) {
		this.passwordHashed = passwordHashed;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhotoPath() {
		return this.photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public List<Article> getArticles1() {
		return this.articles1;
	}

	public void setArticles1(List<Article> articles1) {
		this.articles1 = articles1;
	}

	public Article addArticles1(Article articles1) {
		getArticles1().add(articles1);
		articles1.setUser(this);

		return articles1;
	}

	public Article removeArticles1(Article articles1) {
		getArticles1().remove(articles1);
		articles1.setUser(null);

		return articles1;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setUser(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setUser(null);

		return comment;
	}

	public List<User> getUsers1() {
		return this.users1;
	}

	public void setUsers1(List<User> users1) {
		this.users1 = users1;
	}

	public List<User> getUsers2() {
		return this.users2;
	}

	public void setUsers2(List<User> users2) {
		this.users2 = users2;
	}

	public Education getEducation() {
		return this.education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public List<Article> getArticles2() {
		return this.articles2;
	}

	public void setArticles2(List<Article> articles2) {
		this.articles2 = articles2;
	}

	public List<Listing> getListings1() {
		return this.listings1;
	}

	public void setListings1(List<Listing> listings1) {
		this.listings1 = listings1;
	}

	public List<Listing> getListings2() {
		return this.listings2;
	}

	public void setListings2(List<Listing> listings2) {
		this.listings2 = listings2;
	}

	public Listing addListings2(Listing listings2) {
		getListings2().add(listings2);
		listings2.setUser(this);

		return listings2;
	}

	public Listing removeListings2(Listing listings2) {
		getListings2().remove(listings2);
		listings2.setUser(null);

		return listings2;
	}

	public List<Message> getMessages1() {
		return this.messages1;
	}

	public void setMessages1(List<Message> messages1) {
		this.messages1 = messages1;
	}

	public Message addMessages1(Message messages1) {
		getMessages1().add(messages1);
		messages1.setUser1(this);

		return messages1;
	}

	public Message removeMessages1(Message messages1) {
		getMessages1().remove(messages1);
		messages1.setUser1(null);

		return messages1;
	}

	public List<Message> getMessages2() {
		return this.messages2;
	}

	public void setMessages2(List<Message> messages2) {
		this.messages2 = messages2;
	}

	public Message addMessages2(Message messages2) {
		getMessages2().add(messages2);
		messages2.setUser2(this);

		return messages2;
	}

	public Message removeMessages2(Message messages2) {
		getMessages2().remove(messages2);
		messages2.setUser2(null);

		return messages2;
	}

	public Skill getSkill() {
		return this.skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

}