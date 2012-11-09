package com.github.jkschoen.jsma.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Sharegroup {
	
	@XmlElement(name="id")
	private Integer id;
	
	@XmlElement(name="Tag")
	private String tag;
	
	@XmlElement(name="AccessPassworded")
	private Boolean accessPassworded;
	
	@XmlElement(name="AlbumCount")
	private Integer albumCount;
	
	@XmlElement(name="Albums")
	private List<Album> albums;
	
	@XmlElement(name="Description")
	private String description;
	
	@XmlElement(name="Name")
	private String name;
	
	@XmlElement(name="Password")
	private String password;
	
	@XmlElement(name="PasswordHint")
	private String passwordHint;
	
	@XmlElement(name="Passworded")
	private Boolean passworded;
	
	@XmlElement(name="URL")
	private String url;

	public Sharegroup() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Boolean getAccessPassworded() {
		return accessPassworded;
	}

	public void setAccessPassworded(Boolean accessPassworded) {
		this.accessPassworded = accessPassworded;
	}

	public Integer getAlbumCount() {
		return albumCount;
	}

	public void setAlbumCount(Integer albumCount) {
		this.albumCount = albumCount;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordHint() {
		return passwordHint;
	}

	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	}

	public Boolean getPassworded() {
		return passworded;
	}

	public void setPassworded(Boolean passworded) {
		this.passworded = passworded;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((accessPassworded == null) ? 0 : accessPassworded.hashCode());
		result = prime * result
				+ ((albumCount == null) ? 0 : albumCount.hashCode());
		result = prime * result + ((albums == null) ? 0 : albums.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((passwordHint == null) ? 0 : passwordHint.hashCode());
		result = prime * result
				+ ((passworded == null) ? 0 : passworded.hashCode());
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		Sharegroup other = (Sharegroup) obj;
		if (accessPassworded == null) {
			if (other.accessPassworded != null)
				return false;
		} else if (!accessPassworded.equals(other.accessPassworded))
			return false;
		if (albumCount == null) {
			if (other.albumCount != null)
				return false;
		} else if (!albumCount.equals(other.albumCount))
			return false;
		if (albums == null) {
			if (other.albums != null)
				return false;
		} else if (!albums.equals(other.albums))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
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
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (passwordHint == null) {
			if (other.passwordHint != null)
				return false;
		} else if (!passwordHint.equals(other.passwordHint))
			return false;
		if (passworded == null) {
			if (other.passworded != null)
				return false;
		} else if (!passworded.equals(other.passworded))
			return false;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShareGroup [id=" + id + ", tag=" + tag + ", accessPassworded="
				+ accessPassworded + ", albumCount=" + albumCount + ", albums="
				+ albums + ", description=" + description + ", name=" + name
				+ ", password=" + password + ", passwordHint=" + passwordHint
				+ ", passworded=" + passworded + ", url=" + url + "]";
	}
	
}
