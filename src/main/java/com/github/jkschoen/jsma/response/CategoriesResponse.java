package com.github.jkschoen.jsma.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.Category;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class CategoriesResponse  extends SMResponse {
	
	@XmlElement(name="Categories")
	private List<Category> categories;

	public CategoriesResponse() {
	}
	
	public CategoriesResponse(String stat, String method, List<Category> categories) {
		super(stat, method);
		this.categories = categories;
	}



	public  List<Category> getCategories() {
		return categories;
	}

	public void setCategories( List<Category> category) {
		this.categories = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((categories == null) ? 0 : categories.hashCode());
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
		CategoriesResponse other = (CategoriesResponse) obj;
		if (categories == null) {
			if (other.categories != null)
				return false;
		} else if (!categories.equals(other.categories))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CategoriesResponse ["+toStringSuper()+", categories=" + categories + "]";
	}

}
