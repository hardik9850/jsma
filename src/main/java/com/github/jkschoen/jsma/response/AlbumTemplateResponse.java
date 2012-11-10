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
	
	public AlbumTemplate getAlbumTemplate() {
		return albumTemplate;
	}

	public void setAlbumTemplate(AlbumTemplate albumTemplate) {
		this.albumTemplate = albumTemplate;
	}

	@Override
	public String toString() {
		return "AlbumTemplateResponse ["+toStringSuper()+", albumTemplate=" + albumTemplate + "]";
	}
}
