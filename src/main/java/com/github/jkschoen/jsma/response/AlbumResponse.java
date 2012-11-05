package com.github.jkschoen.jsma.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.Album;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class AlbumResponse extends SMResponse {
	
	@XmlElement(name="Album")
	private Album album;

	public AlbumResponse() {
	}
	
	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	@Override
	public String toString() {
		return "AlbumResponse ["+toStringSuper()+", album=" + album + "]";
	}
}