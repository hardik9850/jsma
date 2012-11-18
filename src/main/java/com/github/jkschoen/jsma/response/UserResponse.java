package com.github.jkschoen.jsma.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.User;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class UserResponse extends SMResponse {
	
	@XmlElement(name="User")
	private User user;

	public UserResponse() {
	}
	
	public UserResponse(String stat, String method, User user) {
		super(stat, method);
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User album) {
		this.user = album;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserResponse other = (UserResponse) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserResponse ["+toStringSuper()+", user=" + user + "]";
	}
}
