package com.github.jkschoen.jsma.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Printmark {

	@XmlElement(name="id")
	private Integer id;
	
	@XmlElement(name="Name")
	private String name;
	
	@XmlElement(name="Dissolve")
	private Integer dissolve;
	
	@XmlElement(name="Image")
	private Image image;
	
	@XmlElement(name="Location")
	private String location;
	
	public Printmark(){
	}

	/**
	 * The id for this printmark.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id for this printmark.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * The name for this printmark.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name for this printmark.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * The opacity of this printmark on the target image.
	 */
	public Integer getDissolve() {
		return dissolve;
	}

	/**
	 * Sets the opacity of this printmark on the target image.
	 */
	public void setDissolve(Integer dissolve) {
		this.dissolve = dissolve;
	}

	/**
	 * The image to be used for the printmark
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * Sets the image to be used for the printmark
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	/**
	 * The location of this printmark on the target image.
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the location of this printmark on the target image.
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dissolve == null) ? 0 : dissolve.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
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
		Printmark other = (Printmark) obj;
		if (dissolve == null) {
			if (other.dissolve != null)
				return false;
		} else if (!dissolve.equals(other.dissolve))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
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
		return "Printmark [id=" + id + ", name=" + name + ", dissolve="
				+ dissolve + ", image=" + image + ", location=" + location
				+ "]";
	}
	
}
