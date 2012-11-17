package com.github.jkschoen.jsma.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.Community;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class CommunitiesResponse extends SMResponse {

	@XmlElement(name="Communities")
	private List<Community> communities;

	public CommunitiesResponse() {
	}
	
	public CommunitiesResponse(String stat, String method, List<Community> communities) {
		super(stat, method);
		this.communities = communities;
	}


	public List<Community> getCommunities() {
		return communities;
	}

	public void setCommunities(List<Community> communities) {
		this.communities = communities;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((communities == null) ? 0 : communities.hashCode());
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
		CommunitiesResponse other = (CommunitiesResponse) obj;
		if (communities == null) {
			if (other.communities != null)
				return false;
		} else if (!communities.equals(other.communities))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CommunitiesResponse ["+toStringSuper()+", communities=" + communities + "]";
	}
}
