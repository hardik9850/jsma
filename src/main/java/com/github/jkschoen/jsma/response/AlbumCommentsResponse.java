package com.github.jkschoen.jsma.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.AlbumComments;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class AlbumCommentsResponse extends SMResponse {
	
	@XmlElement(name="Album")
	private AlbumComments album;

	public AlbumCommentsResponse() {
	}

	public AlbumCommentsResponse(String stat, String method, AlbumComments album) {
		super(stat, method);
		this.album = album;
	}

	public AlbumComments getAlbum() {
		return album;
	}

	public void setAlbum(AlbumComments album) {
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
		AlbumCommentsResponse other = (AlbumCommentsResponse) obj;
		if (album == null) {
			if (other.album != null)
				return false;
		} else if (!album.equals(other.album))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AlbumCommentsResponse ["+toStringSuper()+", album=" + album + "]";
	}
	
	

}
