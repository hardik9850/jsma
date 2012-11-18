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
	
	public FriendsResponse(String stat, String method, List<Friend> friends) {
		super(stat, method);
		this.friends = friends;
	}

	public List<Friend> getFriends() {
		return friends;
	}

	public void setFriends(List<Friend> friends) {
		this.friends = friends;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((friends == null) ? 0 : friends.hashCode());
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
		FriendsResponse other = (FriendsResponse) obj;
		if (friends == null) {
			if (other.friends != null)
				return false;
		} else if (!friends.equals(other.friends))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FriendsResponse ["+toStringSuper()+", friends=" + friends + "]";
	}
}