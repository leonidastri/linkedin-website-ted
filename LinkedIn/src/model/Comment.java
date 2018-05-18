package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/* for xml marshalling */
//import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlAccessType;

/**
 * The persistent class for the comment database table.
 * 
 */

//@XmlRootElement // for xml marshalling
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="comment")
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@XmlAttribute // for xml marshalling
	@XmlID
	@Id
	private String commentID;

	@XmlElement(name="publicationDate") // for xml marshalling
	@Temporal(TemporalType.DATE)
	@Column(name="pub_date")
	private Date pubDate;

	@XmlElement // for xml marshalling
	private String text;

	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="articleID")
	private Article article;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userID")
	private User user;

	public Comment() {
	}

	public String getCommentID() {
		return this.commentID;
	}

	public void setCommentID(String commentID) {
		this.commentID = commentID;
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