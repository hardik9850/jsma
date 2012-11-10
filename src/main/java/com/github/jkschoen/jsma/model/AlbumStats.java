package com.github.jkschoen.jsma.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Album")
@XmlAccessorType(XmlAccessType.FIELD)
public class AlbumStats extends Stats {
	
	@XmlElement(name="id")
	private Integer id;
	
	@XmlElement(name="Key")
	private String key;
	
	@XmlElement(name="Images ")
	private List<ImageStats> images;

	public AlbumStats() {
	}

	/**
	 * The id for this image.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id for this image.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * The key for this image.
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Sets the key for this image.
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Statistics for each image in the album
	 */
	public List<ImageStats> getImages() {
		return images;
	}

	/**
	 * Sets the list of image statistics for each image.
	 */
	public void setImages(List<ImageStats> images) {
		this.images = images;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((images == null) ? 0 : images.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		AlbumStats other = (AlbumStats) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (images == null) {
			if (other.images != null)
				return false;
		} else if (!images.equals(other.images))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AlbumStats [id=" + id + ", key=" + key + ", images=" + images + super.toString() + "]";
	}
	
	
}
