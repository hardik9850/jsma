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
	
	public Printmark getPrintmark() {
		return printmark;
	}

	public void setPrintmark(Printmark printmark) {
		this.printmark = printmark;
	}

	@Override
	public String toString() {
		return "PrintmarkResponse ["+toStringSuper()+", printmark=" + printmark + "]";
	}

}
