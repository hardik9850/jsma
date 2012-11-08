package com.github.jkschoen.jsma.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.Featured;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class FeaturedResponse  extends SMResponse {
	
	@XmlElement(name="Featured")
	private Featured featured;

	public FeaturedResponse() {
	}
	
	public Featured getFeatured() {
		return featured;
	}

	public void setFeatured(Featured album) {
		this.featured = album;
	}

	@Override
	public String toString() {
		return "FeaturedResponse ["+toStringSuper()+", featured=" + featured + "]";
	}

}
