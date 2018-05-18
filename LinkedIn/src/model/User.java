package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/* for xml marshalling */
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;


/**
 * The persistent class for the user database table.
 * 
 */

@XmlRootElement // for xml marshalling
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@XmlAttribute // for xml marshalling
	@XmlID
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String userID;

	@XmlElement // for xml marshalling
	@Column(name="cv_path")
	private String cvPath;

	private String email;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="password_hashed")
	private String passwordHashed;

	@XmlElement // for xml marshalling
	@Column(name="phone_number")
	private String phoneNumber;

	@Column(name="photo_path")
	private String photoPath;

	@XmlElement(name="article")	// for xml marshalling
	@XmlIDREF
	//bi-directional many-to-one association to Article
	@OneToMany(mappedBy="user")
	private List<Article> articles;

	@XmlElement(name="comment")	// for xml marshalling
	@XmlIDREF
	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="user")
	private List<Comment> comments;

	@XmlElement(name="connection1")	// for xml marshalling
	@XmlIDREF
	//bi-directional many-to-one association to Connection
	@OneToMany(mappedBy="user1")
	private List<Connection> connections1;

	@XmlElement(name="connection2")	// for xml marshalling
	@XmlIDREF
	//bi-directional many-to-one association to Connection
	@OneToMany(mappedBy="user2")
	private List<Connection> connections2;

	//bi-directional many-to-one association to Education
	@OneToMany(mappedBy="user")
	private List<Education> educations;

	@XmlElement(name="job")	// for xml marshalling
	@XmlIDREF
	//bi-directional many-to-one association to Job
	@OneToMany(mappedBy="user")
	private List<Job> jobs;

	@XmlElement(name="likeArticle")	// for xml marshalling
	@XmlIDREF
	//bi-directional many-to-one association to LikeArticle
	@OneToMany(mappedBy="user")
	private List<LikeArticle> likeArticles;

	@XmlElement(name="likeListing")	// for xml marshalling
	@XmlIDREF
	//bi-directional many-to-one association to LikeListing
	@OneToMany(mappedBy="user")
	private List<LikeListing> likeListings;

	@XmlElement(name="listing")	// for xml marshalling
	@XmlIDREF
	//bi-directional many-to-one association to Listing
	@OneToMany(mappedBy="user")
	private List<Listing> listings;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="user1")
	private List<Message> messages1;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="user2")
	private List<Message> messages2;

	//bi-directional many-to-one association to Skill
	@OneToMany(mappedBy="user")
	private List<Skill> skills;

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

	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Article addArticle(Article article) {
		getArticles().add(article);
		article.setUser(this);

		return article;
	}

	public Article removeArticle(Article article) {
		getArticles().remove(article);
		article.setUser(null);

		return article;
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

	public List<Listing> getListings() {
		return this.listings;
	}

	public void setListings(List<Listing> listings) {
		this.listings = listings;
	}

	public Listing addListing(Listing listing) {
		getListings().add(listing);
		listing.setUser(this);

		return listing;
	}

	public Listing removeListing(Listing listing) {
		getListings().remove(listing);
		listing.setUser(null);

		return listing;
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

}