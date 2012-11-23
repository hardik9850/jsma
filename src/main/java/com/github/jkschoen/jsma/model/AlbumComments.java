package com.github.jkschoen.jsma.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;


public class AlbumComments {

	
	@XmlElement(name="id")
	private Long id;
	
	@XmlElement(name="Key")
	private String key;
	
	@XmlElement(name="Comments")
	private List<Comment> comments;

	public AlbumComments(){
	}
	
	public AlbumComments(Long id, String key, List<Comment> comments) {
		this.id = id;
		this.key = key;
		this.comments = comments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		AlbumComments other = (AlbumComments) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
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
		return "AlbumComments [id=" + id + ", key=" + key + ", comments="
				+ comments + "]";
	}

}
