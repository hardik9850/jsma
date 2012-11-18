package com.github.jkschoen.jsma.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Family {
	
	@XmlElement(name="Name")
	private String name;

	@XmlElement(name="NickName")
	private String nickName;

	@XmlElement(name="URL")
	private String url;

	public Family() {
	}
	
	public Family(String name, String nickName, String url) {
		this.name = name;
		this.nickName = nickName;
		this.url = url;
	}

	/**
	 * The Name for this user.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the Name for this user.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * The NickName for this user.
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * Set the NickName for this user.
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * The homepage URL for this user.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Set the homepage URL for this user.
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((nickName == null) ? 0 : nickName.hashCode());
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
		Family other = (Family) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
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
		return "Family [name=" + name + ", nickName=" + nickName + ", url="
				+ url + "]";
	}
}
