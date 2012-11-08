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
	
	public List<Family> getFamilies() {
		return families;
	}

	public void setFamilies(List<Family> families) {
		this.families = families;
	}

	@Override
	public String toString() {
		return "FamiliesResponse ["+toStringSuper()+", families=" + families + "]";
	}
}
