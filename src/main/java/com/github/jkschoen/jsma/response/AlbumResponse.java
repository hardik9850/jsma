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

	public AlbumResponse(String stat, String method, Album album) {
		super(stat, method);
		this.album = album;
	}
	
	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((album == null) ? 0 : album.hashCode());
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
		AlbumResponse other = (AlbumResponse) obj;
		if (album == null) {
			if (other.album != null)
				return false;
		} else if (!album.equals(other.album))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AlbumResponse ["+toStringSuper()+", album=" + album + "]";
	}
}