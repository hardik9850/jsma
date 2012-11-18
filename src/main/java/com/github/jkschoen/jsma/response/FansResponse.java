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
	
	public FansResponse(String stat, String method, List<Fan> fans) {
		super(stat, method);
		this.fans = fans;
	}

	public List<Fan> getFans() {
		return fans;
	}

	public void setFans(List<Fan> fans) {
		this.fans = fans;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((fans == null) ? 0 : fans.hashCode());
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
		FansResponse other = (FansResponse) obj;
		if (fans == null) {
			if (other.fans != null)
				return false;
		} else if (!fans.equals(other.fans))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FansResponse ["+toStringSuper()+", fans=" + fans + "]";
	}
}
