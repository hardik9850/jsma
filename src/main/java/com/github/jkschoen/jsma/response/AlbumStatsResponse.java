package com.github.jkschoen.jsma.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.AlbumStats;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class AlbumStatsResponse extends SMResponse {
	
	@XmlElement(name="Album")
	private AlbumStats stats;

	public AlbumStatsResponse() {
	}
	
	public AlbumStatsResponse(String stat, String method, AlbumStats stats) {
		super(stat, method);
		this.stats = stats;
	}

	public AlbumStats getStats() {
		return stats;
	}

	public void setStats(AlbumStats stats) {
		this.stats = stats;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((stats == null) ? 0 : stats.hashCode());
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
		AlbumStatsResponse other = (AlbumStatsResponse) obj;
		if (stats == null) {
			if (other.stats != null)
				return false;
		} else if (!stats.equals(other.stats))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AlbumStatsResponse ["+toStringSuper()+", stats=" + stats + "]";
	}
}