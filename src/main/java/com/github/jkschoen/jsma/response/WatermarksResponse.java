package com.github.jkschoen.jsma.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.github.jkschoen.jsma.model.Watermark;

public class WatermarksResponse extends SMResponse {
	
	@XmlElement(name="Watermarks")
	private List<Watermark> watermarks;

	public WatermarksResponse() {
	}
	
	public WatermarksResponse(String stat, String method, List<Watermark> watermarks) {
		super(stat, method);
		this.watermarks = watermarks;
	}

	public List<Watermark> getWatermarks() {
		return watermarks;
	}

	public void setWatermarks(List<Watermark> watermarks) {
		this.watermarks = watermarks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((watermarks == null) ? 0 : watermarks.hashCode());
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
		WatermarksResponse other = (WatermarksResponse) obj;
		if (watermarks == null) {
			if (other.watermarks != null)
				return false;
		} else if (!watermarks.equals(other.watermarks))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WatermarksResponse ["+toStringSuper()+", watermarks=" + watermarks + "]";
	}

}
