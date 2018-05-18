package model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/* source: http://blog.bdoughan.com/2010/10/jaxb-and-shared-references-xmlid-and.html */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AllUsers {

	@XmlElement(name="user")
	private List<User> users;
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public List<User> getUsers() {
		return this.users;
	}
	
}
