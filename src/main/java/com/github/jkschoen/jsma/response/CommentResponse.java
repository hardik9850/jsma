package com.github.jkschoen.jsma.response;

import javax.xml.bind.annotation.XmlElement;

import com.github.jkschoen.jsma.model.Comment;

public class CommentResponse extends SMResponse {
	
	@XmlElement(name="Comment")
	private Comment comment;

	public CommentResponse() {
	}
	
	public CommentResponse(String stat, String method, Comment comment) {
		super(stat, method);
		this.comment = comment;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentResponse other = (CommentResponse) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CommentResponse ["+toStringSuper()+", comment=" + comment + "]";
	}

}
