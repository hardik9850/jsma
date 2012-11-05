package com.github.jkschoen.jsma.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Comment {
	
	@XmlElement(name="id")
	private Integer id;
	
	//TODO: See what the format is, maybe we can convert this to a java.util.Date
	@XmlElement(name="Date")
	private String date;
	
	@XmlElement(name="Rating")
	private Integer rating;
	
	@XmlElement(name="Text")
	private String text;
	
	//TODO: Find out what this is used for
	@XmlElement(name="Type")
	private String type;
	
	@XmlElement(name="User")
	private User user;

	public Comment() {
	}

	/**
	 * The id for this comment.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Set the id for this comment.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * The date that this comment was posted.
	 *
	 */
	public String getDate() {
		return date;
	}

	/**
	 * The date that this comment was posted.
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * The rating for this comment.
     *
     * Values:
     * 0 - No Rating
     * 1 - 1 Star Rating
     * 2 - 2 Star Rating
     * 3 - 3 Star Rating
     * 4 - 4 Star Rating
     * 5 - 5 Star Rating
	 */
	public Integer getRating() {
		return rating;
	}
    
	/**
	 * Sets the rating for this comment.
     *
     * Values:
     * 0 - No Rating
     * 1 - 1 Star Rating
     * 2 - 2 Star Rating
     * 3 - 3 Star Rating
     * 4 - 4 Star Rating
     * 5 - 5 Star Rating
	 * @param rating
	 */
	public void setRating(int rating) {
		if (rating < 0 || rating > 5){
			throw new RuntimeException("Rating must be >= 0 and <= 5.");
		}
		this.rating = rating;
	}

	/**
	 * The text for this comment.
	 */
	public String getText() {
		return text;
	}

	/**
	 * The type for this comment.
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Have no clue what this is, Will have to investigate
	 */
	public String getType() {
		return type;
	}

	/**
	 * Have no clue what this is, Will have to investigate
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * The user who made this comment
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Set the user who made this comment
	 */
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Comment other = (Comment) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", date=" + date + ", rating=" + rating
				+ ", text=" + text + ", type=" + type + ", user=" + user + "]";
	}
	
}
