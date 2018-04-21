package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the comment database table.
 * 
 */
@Entity
@Table(name="comment")
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String articleID;

	@Temporal(TemporalType.DATE)
	@Column(name="pub_date")
	private Date pubDate;

	private String text;

	//bi-directional one-to-one association to Article
	@OneToOne
	@JoinColumn(name="articleID")
	private Article article;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userID")
	private User user;

	public Comment() {
	}

	public String getArticleID() {
		return this.articleID;
	}

	public void setArticleID(String articleID) {
		this.articleID = articleID;
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

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}