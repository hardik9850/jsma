package com.github.jkschoen.jsma.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.github.jkschoen.jsma.model.Watermark;

public class WatermarksResponse extends SMResponse {
	
	@XmlElement(name="Watermarks")
	private List<Watermark> watermarks;

	public WatermarksResponse() {
	}
	
	public List<Watermark> getWatermarks() {
		return watermarks;
	}

	public void setWatermarks(List<Watermark> watermarks) {
		this.watermarks = watermarks;
	}

	@Override
	public String toString() {
		return "WatermarksResponse ["+toStringSuper()+", watermarks=" + watermarks + "]";
	}

}
