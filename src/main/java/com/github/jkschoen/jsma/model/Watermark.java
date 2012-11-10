package com.github.jkschoen.jsma.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Watermark {

	@XmlElement(name="id")
	private Integer id;
	
	@XmlElement(name="Name")
	private String name;
	
	@XmlElement(name="Dissolve")
	private Integer dissolve;
	
	@XmlElement(name="Image")
	private Image image;
	
	@XmlElement(name="Pinned")
	private String pinned;
	
	@XmlElement(name="Thumbs")
	private Boolean thumbs;
	
	public Watermark(){}

	/**
	 * The id for this watermark.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Set the id for this watermark.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * The name for this watermark.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name for this watermark.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * The opacity of this watermark on the target image.
	 */
	public Integer getDissolve() {
		return dissolve;
	}

	/**
	 * Set the opacity of this watermark on the target image.
	 */
	public void setDissolve(Integer dissolve) {
		this.dissolve = dissolve;
	}

	/**
	 * The image to use for the watermark.
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * Set the image to use for the watermark.
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	/**
	 * The location of this watermark on the target image.
	 */
	public String getPinned() {
		return pinned;
	}

	/**
	 * Set the location of this watermark on the target image.
	 */
	public void setPinned(String pinned) {
		this.pinned = pinned;
	}

	/**
	 * This watermark is applied to thumbnail image sizes.
	 */
	public Boolean getThumbs() {
		return thumbs;
	}

	/**
	 * Sets whether this watermark is applied to thumbnail image sizes.
	 */
	public void setThumbs(Boolean thumbs) {
		this.thumbs = thumbs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dissolve == null) ? 0 : dissolve.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pinned == null) ? 0 : pinned.hashCode());
		result = prime * result + ((thumbs == null) ? 0 : thumbs.hashCode());
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
		Watermark other = (Watermark) obj;
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pinned == null) {
			if (other.pinned != null)
				return false;
		} else if (!pinned.equals(other.pinned))
			return false;
		if (thumbs == null) {
			if (other.thumbs != null)
				return false;
		} else if (!thumbs.equals(other.thumbs))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Watermark [id=" + id + ", name=" + name + ", dissolve="
				+ dissolve + ", image=" + image + ", pinned=" + pinned
				+ ", thumbs=" + thumbs + "]";
	}
}
