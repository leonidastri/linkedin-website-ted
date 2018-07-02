package model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;


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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String skillID;

	private String skill;
	
	@Column(name="private")
	private Boolean priv;

	//bi-directional many-to-one association to User
	@XmlTransient
	@ManyToOne
	@JoinColumn(name="userID")
	@XmlInverseReference(mappedBy="skill")
	private User user;

	public Skill() {
	}

	public String getSkillID() {
		return this.skillID;
	}

	public void setSkillID(String skillID) {
		this.skillID = skillID;
	}

	public String getSkill() {
		return this.skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	public Boolean getPrivate() {
		return this.priv;
	}
	
	public void setPrivate(Boolean priv) {
		this.priv = priv;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}