package com.github.jkschoen.jsma.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.Category;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class CategoryResponse extends SMResponse {
	
	@XmlElement(name="Category")
	private Category category;

	public CategoryResponse() {
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "CategoryResponse ["+toStringSuper()+", category=" + category + "]";
	}
}
