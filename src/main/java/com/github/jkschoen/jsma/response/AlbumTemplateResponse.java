package com.github.jkschoen.jsma.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.AlbumTemplate;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class AlbumTemplateResponse extends SMResponse {
	
	@XmlElement(name="AlbumTemplate")
	private AlbumTemplate albumTemplate;

	public AlbumTemplateResponse() {
	}
	
	public AlbumTemplateResponse(String stat, String method, AlbumTemplate albumTemplate) {
		super(stat, method);
		this.albumTemplate = albumTemplate;
	}
	
	public AlbumTemplate getAlbumTemplate() {
		return albumTemplate;
	}

	public void setAlbumTemplate(AlbumTemplate albumTemplate) {
		this.albumTemplate = albumTemplate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((albumTemplate == null) ? 0 : albumTemplate.hashCode());
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
		AlbumTemplateResponse other = (AlbumTemplateResponse) obj;
		if (albumTemplate == null) {
			if (other.albumTemplate != null)
				return false;
		} else if (!albumTemplate.equals(other.albumTemplate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AlbumTemplateResponse ["+toStringSuper()+", albumTemplate=" + albumTemplate + "]";
	}
}
