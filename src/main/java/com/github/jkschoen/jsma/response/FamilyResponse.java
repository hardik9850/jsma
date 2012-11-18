package com.github.jkschoen.jsma.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.Family;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class FamilyResponse  extends SMResponse {

	@XmlElement(name="Family")
	private List<Family> families;

	public FamilyResponse() {
	}
	
	public FamilyResponse(String stat, String method, List<Family> families) {
		super(stat, method);
		this.families = families;
	}

	public List<Family> getFamilies() {
		return families;
	}

	public void setFamilies(List<Family> families) {
		this.families = families;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((families == null) ? 0 : families.hashCode());
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
		FamilyResponse other = (FamilyResponse) obj;
		if (families == null) {
			if (other.families != null)
				return false;
		} else if (!families.equals(other.families))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FamilyResponse ["+toStringSuper()+", families=" + families + "]";
	}
}
