package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the skill database table.
 * 
 */
@Entity
@Table(name="skill")
@NamedQuery(name="Skill.findAll", query="SELECT s FROM Skill s")
public class Skill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String userID;

	private String skill;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="userID")
	private User user;

	public Skill() {
	}

	public String getUserID() {
		return this.userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getSkill() {
		return this.skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}