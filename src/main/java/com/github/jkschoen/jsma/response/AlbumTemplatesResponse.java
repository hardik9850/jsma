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
	
	@XmlElement(name="Album")
	private List<AlbumTemplate> albumTemplates;

	public AlbumTemplatesResponse() {
	}
	
	public List<AlbumTemplate> getAlbumTemplates() {
		return albumTemplates;
	}

	public void setAlbumTemplates(List<AlbumTemplate> albumTemplates) {
		this.albumTemplates = albumTemplates;
	}

	@Override
	public String toString() {
		return "AlbumTemplatesResponse ["+toStringSuper()+", albumTemplates=" + albumTemplates + "]";
	}
}
