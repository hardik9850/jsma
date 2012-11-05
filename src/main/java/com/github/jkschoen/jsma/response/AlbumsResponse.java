package com.github.jkschoen.jsma.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.Album;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class AlbumsResponse extends SMResponse {

	@XmlElement(name="Albums")
	private List<Album> albums;

	public AlbumsResponse() {
	}
	
	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	@Override
	public String toString() {
		return "AlbumsResponse ["+toStringSuper()+", albums=" + albums + "]";
	}
}