package com.github.jkschoen.jsma.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.Printmark;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class PrintmarksResponse extends SMResponse {
	
	@XmlElement(name="Printmarks")
	private List<Printmark> printmarks;

	public PrintmarksResponse() {
	}
	
	public PrintmarksResponse(String stat, String method, List<Printmark> printmarks) {
		super(stat, method);
		this.printmarks = printmarks;
	}

	public List<Printmark> getPrintmarks() {
		return printmarks;
	}

	public void setPrintmarks(List<Printmark> printmarks) {
		this.printmarks = printmarks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((printmarks == null) ? 0 : printmarks.hashCode());
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
		PrintmarksResponse other = (PrintmarksResponse) obj;
		if (printmarks == null) {
			if (other.printmarks != null)
				return false;
		} else if (!printmarks.equals(other.printmarks))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PrintmarksResponse ["+toStringSuper()+", printmarks=" + printmarks + "]";
	}

}
