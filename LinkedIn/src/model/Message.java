package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


/**
 * The persistent class for the message database table.
 * 
 */
@Entity
@Table(name="message")
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
@XmlAccessorType(XmlAccessType.FIELD)
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String messageID;

	private String text;

	@XmlElement(name="publicationDate") // for xml marshalling
	@Temporal(TemporalType.DATE)
	@Column(name="pub_date")
	private Date pubDate;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="senderID")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="receiverID")
	private User user2;

	public Message() {
	}

	public String getMessageID() {
		return this.messageID;
	}

	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getPubDate() {
		return this.pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

}