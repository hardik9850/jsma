package com.github.jkschoen.jsma.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.Comment;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ImageCommentResponse extends SMResponse {
	
	@XmlElement(name="Comment")
	private Comment comment;

	public ImageCommentResponse() {
	}
	
	public Comment getComment() {
		return comment;
	}

	public void setAlbum(Comment comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "ImageCommentResponse ["+toStringSuper()+", comment=" + comment + "]";
	}
}