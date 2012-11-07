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
	
	public List<Community> getCommunities() {
		return communities;
	}

	public void setCommunities(List<Community> communities) {
		this.communities = communities;
	}

	@Override
	public String toString() {
		return "CommunitiesResponse ["+toStringSuper()+", communities=" + communities + "]";
	}
}
