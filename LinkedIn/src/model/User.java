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

	//bi-directional many-to-one association to Connection
	@OneToMany(mappedBy="user1")
	private List<Connection> connections1;

	//bi-directional many-to-one association to Connection
	@OneToMany(mappedBy="user2")
	private List<Connection> connections2;

	//bi-directional many-to-one association to Education
	@OneToMany(mappedBy="user")
	private List<Education> educations;

	//bi-directional many-to-one association to Job
	@OneToMany(mappedBy="user")
	private List<Job> jobs;

	//bi-directional many-to-one association to LikeArticle
	@OneToMany(mappedBy="user")
	private List<LikeArticle> likeArticles;

	//bi-directional many-to-one association to LikeListing
	@OneToMany(mappedBy="user")
	private List<LikeListing> likeListings;

	//bi-directional many-to-one association to Listing
	@OneToMany(mappedBy="user")
	private List<Listing> listings1;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="user1")
	private List<Message> messages1;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="user2")
	private List<Message> messages2;

	//bi-directional many-to-one association to Skill
	@OneToMany(mappedBy="user")
	private List<Skill> skills;

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
	private List<Listing> listings2;

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

	public List<Connection> getConnections1() {
		return this.connections1;
	}

	public void setConnections1(List<Connection> connections1) {
		this.connections1 = connections1;
	}

	public Connection addConnections1(Connection connections1) {
		getConnections1().add(connections1);
		connections1.setUser1(this);

		return connections1;
	}

	public Connection removeConnections1(Connection connections1) {
		getConnections1().remove(connections1);
		connections1.setUser1(null);

		return connections1;
	}

	public List<Connection> getConnections2() {
		return this.connections2;
	}

	public void setConnections2(List<Connection> connections2) {
		this.connections2 = connections2;
	}

	public Connection addConnections2(Connection connections2) {
		getConnections2().add(connections2);
		connections2.setUser2(this);

		return connections2;
	}

	public Connection removeConnections2(Connection connections2) {
		getConnections2().remove(connections2);
		connections2.setUser2(null);

		return connections2;
	}

	public List<Education> getEducations() {
		return this.educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	public Education addEducation(Education education) {
		getEducations().add(education);
		education.setUser(this);

		return education;
	}

	public Education removeEducation(Education education) {
		getEducations().remove(education);
		education.setUser(null);

		return education;
	}

	public List<Job> getJobs() {
		return this.jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public Job addJob(Job job) {
		getJobs().add(job);
		job.setUser(this);

		return job;
	}

	public Job removeJob(Job job) {
		getJobs().remove(job);
		job.setUser(null);

		return job;
	}

	public List<LikeArticle> getLikeArticles() {
		return this.likeArticles;
	}

	public void setLikeArticles(List<LikeArticle> likeArticles) {
		this.likeArticles = likeArticles;
	}

	public LikeArticle addLikeArticle(LikeArticle likeArticle) {
		getLikeArticles().add(likeArticle);
		likeArticle.setUser(this);

		return likeArticle;
	}

	public LikeArticle removeLikeArticle(LikeArticle likeArticle) {
		getLikeArticles().remove(likeArticle);
		likeArticle.setUser(null);

		return likeArticle;
	}

	public List<LikeListing> getLikeListings() {
		return this.likeListings;
	}

	public void setLikeListings(List<LikeListing> likeListings) {
		this.likeListings = likeListings;
	}

	public LikeListing addLikeListing(LikeListing likeListing) {
		getLikeListings().add(likeListing);
		likeListing.setUser(this);

		return likeListing;
	}

	public LikeListing removeLikeListing(LikeListing likeListing) {
		getLikeListings().remove(likeListing);
		likeListing.setUser(null);

		return likeListing;
	}

	public List<Listing> getListings1() {
		return this.listings1;
	}

	public void setListings1(List<Listing> listings1) {
		this.listings1 = listings1;
	}

	public Listing addListings1(Listing listings1) {
		getListings1().add(listings1);
		listings1.setUser(this);

		return listings1;
	}

	public Listing removeListings1(Listing listings1) {
		getListings1().remove(listings1);
		listings1.setUser(null);

		return listings1;
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

	public List<Skill> getSkills() {
		return this.skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public Skill addSkill(Skill skill) {
		getSkills().add(skill);
		skill.setUser(this);

		return skill;
	}

	public Skill removeSkill(Skill skill) {
		getSkills().remove(skill);
		skill.setUser(null);

		return skill;
	}

	public List<Article> getArticles2() {
		return this.articles2;
	}

	public void setArticles2(List<Article> articles2) {
		this.articles2 = articles2;
	}

	public List<Listing> getListings2() {
		return this.listings2;
	}

	public void setListings2(List<Listing> listings2) {
		this.listings2 = listings2;
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

}