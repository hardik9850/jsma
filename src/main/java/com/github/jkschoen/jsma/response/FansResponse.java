package com.github.jkschoen.jsma.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.Fan;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class FansResponse  extends SMResponse {

	@XmlElement(name="Fans")
	private List<Fan> fans;

	public FansResponse() {
	}
	
	public List<Fan> getFans() {
		return fans;
	}

	public void setFans(List<Fan> fans) {
		this.fans = fans;
	}

	@Override
	public String toString() {
		return "FansResponse ["+toStringSuper()+", fans=" + fans + "]";
	}
}
