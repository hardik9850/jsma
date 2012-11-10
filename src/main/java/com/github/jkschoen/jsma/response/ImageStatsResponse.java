package com.github.jkschoen.jsma.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.ImageStats;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class ImageStatsResponse extends SMResponse {

	@XmlElement(name="Image")
	private ImageStats stats;

	public ImageStatsResponse() {
	}
	
	public ImageStats getStats() {
		return stats;
	}

	public void setStats(ImageStats stats) {
		this.stats = stats;
	}

	@Override
	public String toString() {
		return "ImageStatsResponse ["+toStringSuper()+", stats=" + stats + "]";
	}
}
