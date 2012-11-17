package com.github.jkschoen.jsma.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.AlbumTemplate;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class AlbumTemplatesResponse extends SMResponse {
	
	@XmlElement(name="AlbumTemplates")
	private List<AlbumTemplate> albumTemplates;

	public AlbumTemplatesResponse() {
	}
	
	public AlbumTemplatesResponse(String stat, String method, List<AlbumTemplate> albumTemplates) {
		super(stat, method);
		this.albumTemplates = albumTemplates;
	}

	public List<AlbumTemplate> getAlbumTemplates() {
		return albumTemplates;
	}

	public void setAlbumTemplates(List<AlbumTemplate> albumTemplates) {
		this.albumTemplates = albumTemplates;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((albumTemplates == null) ? 0 : albumTemplates.hashCode());
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
		AlbumTemplatesResponse other = (AlbumTemplatesResponse) obj;
		if (albumTemplates == null) {
			if (other.albumTemplates != null)
				return false;
		} else if (!albumTemplates.equals(other.albumTemplates))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AlbumTemplatesResponse ["+toStringSuper()+", albumTemplates=" + albumTemplates + "]";
	}
}
