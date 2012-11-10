package com.github.jkschoen.jsma.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.Watermark;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class WatermarkResponse extends SMResponse {
	
	@XmlElement(name="Watermark")
	private Watermark watermark;

	public WatermarkResponse() {
	}
	
	public Watermark getWatermark() {
		return watermark;
	}

	public void setWatermark(Watermark watermark) {
		this.watermark = watermark;
	}

	@Override
	public String toString() {
		return "WatermarkResponse ["+toStringSuper()+", watermark=" + watermark + "]";
	}
}
