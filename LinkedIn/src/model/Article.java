package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the article database table.
 * 
 */
@Entity
@Table(name="article")
@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String articleID;

	@Column(name="picture_path")
	private String picturePath;

	@Temporal(TemporalType.DATE)
	@Column(name="pub_date")
	private Date pubDate;

	private String text;

	private String title;

	@Column(name="video_path")
	private String videoPath;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="authorID")
	private User user;

	//bi-directional one-to-one association to Comment
	@OneToOne(mappedBy="article")
	private Comment comment;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="articles2")
	private List<User> users;

	public Article() {
	}

	public String getArticleID() {
		return this.articleID;
	}

	public void setArticleID(String articleID) {
		this.articleID = articleID;
	}

	public String getPicturePath() {
		return this.picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public Date getPubDate() {
		return this.pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVideoPath() {
		return this.videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Comment getComment() {
		return this.comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}