package com.github.jkschoen.jsma.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Category {

	@XmlElement(name="id")
	private Integer id;
	
	@XmlElement(name="Name")
	private String name;

	@XmlElement(name="NiceName")
	private String niceName;
	
	@XmlElement(name="Type")
	private String type;
	
	public Category(){
	}
	
	public Category(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * The id for this category.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Set the id for this category.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * The name for this category.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name for this category.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * The nicename for this category.
	 */
	public String getNiceName() {
		return niceName;
	}

	/**
	 * Set the nicename for this category.
	 */
	public void setNiceName(String niceName) {
		this.niceName = niceName;
	}

	/**
	 * The type for this category.
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Set the type for this category.
	 */
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((niceName == null) ? 0 : niceName.hashCode());
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
		Category other = (Category) obj;
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
		if (niceName == null) {
			if (other.niceName != null)
				return false;
		} else if (!niceName.equals(other.niceName))
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
		return "Category [id=" + id + ", name=" + name + ", niceName="
				+ niceName + ", type=" + type + "]";
	}
}
