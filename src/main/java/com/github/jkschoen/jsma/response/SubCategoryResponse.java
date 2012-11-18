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
	
	public SubCategoryResponse(String stat, String method, SubCategory subCategory) {
		super(stat, method);
		this.subCategory = subCategory;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory album) {
		this.subCategory = album;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((subCategory == null) ? 0 : subCategory.hashCode());
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
		SubCategoryResponse other = (SubCategoryResponse) obj;
		if (subCategory == null) {
			if (other.subCategory != null)
				return false;
		} else if (!subCategory.equals(other.subCategory))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SubCategoryResponse ["+toStringSuper()+", subCategory=" + subCategory + "]";
	}

}
