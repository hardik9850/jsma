package com.github.jkschoen.jsma.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.SubCategory;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class SubCategoriesResponse  extends SMResponse {

	@XmlElement(name="SubCategories")
	private List<SubCategory> subCategories;

	public SubCategoriesResponse() {
	}
	
	public SubCategoriesResponse(String stat, String method, List<SubCategory> subCategories) {
		super(stat, method);
		this.subCategories = subCategories;
	}
	
	public List<SubCategory> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}

	@Override
	public String toString() {
		return "SubCategoriesResponse ["+toStringSuper()+", subCategories=" + subCategories + "]";
	}

}
