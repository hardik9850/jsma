package com.github.jkschoen.jsma.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.Friend;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class FriendsResponse  extends SMResponse {

	@XmlElement(name="Friends")
	private List<Friend> friends;

	public FriendsResponse() {
	}
	
	public List<Friend> getFriends() {
		return friends;
	}

	public void setFriends(List<Friend> friends) {
		this.friends = friends;
	}

	@Override
	public String toString() {
		return "FriendsResponse ["+toStringSuper()+", friends=" + friends + "]";
	}
}