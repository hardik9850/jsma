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
	
	public WatermarkResponse(String stat, String method, Watermark watermark) {
		super(stat, method);
		this.watermark = watermark;
	}

	public Watermark getWatermark() {
		return watermark;
	}

	public void setWatermark(Watermark watermark) {
		this.watermark = watermark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((watermark == null) ? 0 : watermark.hashCode());
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
		WatermarkResponse other = (WatermarkResponse) obj;
		if (watermark == null) {
			if (other.watermark != null)
				return false;
		} else if (!watermark.equals(other.watermark))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WatermarkResponse ["+toStringSuper()+", watermark=" + watermark + "]";
	}
}
