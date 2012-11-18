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
	
	public FeaturedResponse(String stat, String method, Featured featured) {
		super(stat, method);
		this.featured = featured;
	}

	public Featured getFeatured() {
		return featured;
	}

	public void setFeatured(Featured album) {
		this.featured = album;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((featured == null) ? 0 : featured.hashCode());
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
		FeaturedResponse other = (FeaturedResponse) obj;
		if (featured == null) {
			if (other.featured != null)
				return false;
		} else if (!featured.equals(other.featured))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FeaturedResponse ["+toStringSuper()+", featured=" + featured + "]";
	}

}
