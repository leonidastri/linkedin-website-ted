package model;

import java.io.Serializable;
import javax.persistence.*;

/* for xml marshalling */
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;


/**
 * The persistent class for the like_article database table.
 * 
 */

@XmlRootElement // for xml marshalling
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="like_article")
@NamedQuery(name="LikeArticle.findAll", query="SELECT l FROM LikeArticle l")
public class LikeArticle implements Serializable {
	private static final long serialVersionUID = 1L;

	@XmlAttribute
	@Id
	private String like_articleID;

	@XmlElement(name="article")
	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="articleID")
	private Article article;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userID")
	private User user;

	public LikeArticle() {
	}

	public String getLike_articleID() {
		return this.like_articleID;
	}

	public void setLike_articleID(String like_articleID) {
		this.like_articleID = like_articleID;
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