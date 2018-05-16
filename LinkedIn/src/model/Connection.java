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
 * The persistent class for the connection database table.
 * 
 */

@XmlRootElement // for xml marshalling
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="connection")
@NamedQuery(name="Connection.findAll", query="SELECT c FROM Connection c")
public class Connection implements Serializable {
	private static final long serialVersionUID = 1L;

	@XmlAttribute
	@Id
	private String connectionID;

	@XmlElement(name="user1")
	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userID_1")
	private User user1;

	@XmlElement(name="user2")
	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userID_2")
	private User user2;

	public Connection() {
	}

	public String getConnectionID() {
		return this.connectionID;
	}

	public void setConnectionID(String connectionID) {
		this.connectionID = connectionID;
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