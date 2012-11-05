package com.github.jkschoen.jsma.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.AlbumStats;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class AlbumStatsResponse extends SMResponse {
	
	@XmlElement(name="Comment")
	private AlbumStats stats;

	public AlbumStatsResponse() {
	}
	
	public AlbumStats getStats() {
		return stats;
	}

	public void setStats(AlbumStats stats) {
		this.stats = stats;
	}

	@Override
	public String toString() {
		return "AlbumStatsResponse ["+toStringSuper()+", stats=" + stats + "]";
	}
}