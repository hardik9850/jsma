package com.github.jkschoen.jsma.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.Printmark;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class PrintmarkResponse extends SMResponse {
	
	@XmlElement(name="Printmark")
	private Printmark printmark;

	public PrintmarkResponse() {
	}
	
	public PrintmarkResponse(String stat, String method, Printmark printmark) {
		super(stat, method);
		this.printmark = printmark;
	}

	public Printmark getPrintmark() {
		return printmark;
	}

	public void setPrintmark(Printmark printmark) {
		this.printmark = printmark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((printmark == null) ? 0 : printmark.hashCode());
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
		PrintmarkResponse other = (PrintmarkResponse) obj;
		if (printmark == null) {
			if (other.printmark != null)
				return false;
		} else if (!printmark.equals(other.printmark))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PrintmarkResponse ["+toStringSuper()+", printmark=" + printmark + "]";
	}

}
