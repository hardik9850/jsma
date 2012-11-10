package com.github.jkschoen.jsma.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.SubCategory;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class SubCategoryResponse  extends SMResponse {
	
	@XmlElement(name="SubCategory")
	private SubCategory subCategory;

	public SubCategoryResponse() {
	}
	
	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory album) {
		this.subCategory = album;
	}

	@Override
	public String toString() {
		return "SubCategoryResponse ["+toStringSuper()+", subCategory=" + subCategory + "]";
	}

}
