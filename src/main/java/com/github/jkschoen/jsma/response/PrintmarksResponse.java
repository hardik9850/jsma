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
	
	public List<Printmark> getPrintmarks() {
		return printmarks;
	}

	public void setPrintmarks(List<Printmark> printmarks) {
		this.printmarks = printmarks;
	}

	@Override
	public String toString() {
		return "PrintmarksResponse ["+toStringSuper()+", printmarks=" + printmarks + "]";
	}

}
