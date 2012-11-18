package com.github.jkschoen.jsma.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="Image")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImageStats extends Stats{
	
	@XmlElement(name="id")
	private Integer id;
	
	@XmlElement(name="Key")
	private String key;

	public ImageStats() {
	}
	
	public ImageStats(Integer id, String key, Integer bytes, 
			Integer hits, Integer large, Integer medium, 
			Integer original, Integer small, Integer x2Large, 
			Integer x3Large, Integer xLarge) {
		super(bytes, hits, large, medium, original, small, x2Large, x3Large, xLarge);
		this.id = id;
		this.key = key;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ImageStats other = (ImageStats) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "ImageStats [id=" + id + ", key=" + key + super.toString() + "]";
	}

	
}
