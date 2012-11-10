package com.github.jkschoen.jsma.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AlbumTemplate extends AlbumBase{
	
	@XmlElement(name="AlbumTemplateName")
	private String albumTemplateName;

	public AlbumTemplate() {
		super();
	}

	public String getAlbumTemplateName() {
		return albumTemplateName;
	}

	public void setAlbumTemplateName(String albumTemplateName) {
		this.albumTemplateName = albumTemplateName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((albumTemplateName == null) ? 0 : albumTemplateName
						.hashCode());
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
		AlbumTemplate other = (AlbumTemplate) obj;
		if (albumTemplateName == null) {
			if (other.albumTemplateName != null)
				return false;
		} else if (!albumTemplateName.equals(other.albumTemplateName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AlbumTemplate ["+super.toString()+", albumTemplateName=" + albumTemplateName + "]";
	}
	
}
