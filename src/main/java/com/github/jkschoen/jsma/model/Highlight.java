package com.github.jkschoen.jsma.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Highlight {
	
	@XmlElement(name="id")
	private Integer id;
	
	@XmlElement(name="Key")
	private String key;
	
	@XmlElement(name="Type")
	private String type;

	public Highlight() {
		super();
	}

	/**
	 * The id for this image.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Set the id for this image.
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
	 * Set the key for this image.
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * The type for this highlight image.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set the type for this highlight image.
	 */
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Highlight other = (Highlight) obj;
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
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Highlight [id=" + id + ", key=" + key + ", type=" + type + "]";
	}
	
}
