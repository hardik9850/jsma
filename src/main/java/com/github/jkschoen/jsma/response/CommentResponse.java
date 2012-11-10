package com.github.jkschoen.jsma.response;

import javax.xml.bind.annotation.XmlElement;

import com.github.jkschoen.jsma.model.Comment;

public class CommentResponse extends SMResponse {
	
	@XmlElement(name="Comment")
	private Comment comment;

	public CommentResponse() {
	}
	
	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "CommentResponse ["+toStringSuper()+", comment=" + comment + "]";
	}

}
