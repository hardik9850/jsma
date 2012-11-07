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
	
	public  List<Category> getCategories() {
		return categories;
	}

	public void setCategories( List<Category> category) {
		this.categories = category;
	}

	@Override
	public String toString() {
		return "CategoriesResponse ["+toStringSuper()+", categories=" + categories + "]";
	}

}
