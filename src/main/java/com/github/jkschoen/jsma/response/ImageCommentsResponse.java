package com.github.jkschoen.jsma.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.Comment;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ImageCommentsResponse extends SMResponse {
	
	@XmlElement(name="Comment")
	private List<Comment> comments;

	public ImageCommentsResponse() {
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setAlbum(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "ImageCommentsResponse ["+toStringSuper()+", comments=" + comments + "]";
	}
}