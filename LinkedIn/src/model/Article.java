package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/* for xml marshalling */
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;


/**
 * The persistent class for the article database table.
 * 
 */

@XmlRootElement // for xml marshalling
@Entity
@Table(name="article")
@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@XmlAttribute // for xml marshalling
	@Id
	private String articleID;

	@Column(name="picture_path")
	private String picturePath;

	@XmlElement(name="publicationDate")
	@Temporal(TemporalType.DATE)
	@Column(name="pub_date")
	private Date pubDate;

	@XmlElement
	private String text;

	@XmlElement
	private String title;

	@Column(name="video_path")
	private String videoPath;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="authorID")
	private User user;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="article")
	private List<Comment> comments;

	//bi-directional many-to-one association to LikeArticle
	@OneToMany(mappedBy="article")
	private List<LikeArticle> likeArticles;

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

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setArticle(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setArticle(null);

		return comment;
	}

	public List<LikeArticle> getLikeArticles() {
		return this.likeArticles;
	}

	public void setLikeArticles(List<LikeArticle> likeArticles) {
		this.likeArticles = likeArticles;
	}

	public LikeArticle addLikeArticle(LikeArticle likeArticle) {
		getLikeArticles().add(likeArticle);
		likeArticle.setArticle(this);

		return likeArticle;
	}

	public LikeArticle removeLikeArticle(LikeArticle likeArticle) {
		getLikeArticles().remove(likeArticle);
		likeArticle.setArticle(null);

		return likeArticle;
	}

}