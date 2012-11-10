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
	
	public User getUser() {
		return user;
	}

	public void setUser(User album) {
		this.user = album;
	}

	@Override
	public String toString() {
		return "UserResponse ["+toStringSuper()+", user=" + user + "]";
	}
}
