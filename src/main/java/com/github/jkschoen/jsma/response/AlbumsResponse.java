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
	
	public AlbumsResponse(String stat, String method, List<Album> albums) {
		super(stat, method);
		this.albums = albums;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((albums == null) ? 0 : albums.hashCode());
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
		AlbumsResponse other = (AlbumsResponse) obj;
		if (albums == null) {
			if (other.albums != null)
				return false;
		} else if (!albums.equals(other.albums))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AlbumsResponse ["+toStringSuper()+", albums=" + albums + "]";
	}
}