package com.github.jkschoen.jsma.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Community {

	@XmlElement(name="id")
	private Integer id;
	
	@XmlElement(name="Name")
	private String name;

	public Community() {
	}

	public Community(Integer id) {
		this.id = id;
	}

	/**
	 * The id for this community.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Set the id for this community.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * The name for this community.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name for this community.
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Community other = (Community) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Community [id=" + id + ", name=" + name + "]";
	}
	
}
