package com.github.jkschoen.jsma.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="User")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserStats extends Stats{

	
	@XmlElement(name="Albums ")
	private List<AlbumStats> albums;
	
	public UserStats(){
	}
	
	public UserStats(Integer bytes, 
			Integer hits, Integer large, Integer medium, 
			Integer original, Integer small, Integer x2Large, 
			Integer x3Large, Integer xLarge) {
		super(bytes, hits, large, medium, original, small, x2Large, x3Large, xLarge);
	}

	public List<AlbumStats> getAlbums() {
		return albums;
	}

	public void setAlbums(List<AlbumStats> albums) {
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
		UserStats other = (UserStats) obj;
		if (albums == null) {
			if (other.albums != null)
				return false;
		} else if (!albums.equals(other.albums))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserStats [albums=" + albums + super.toString() + "]";
	}
	
	

}
