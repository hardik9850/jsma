package com.github.jkschoen.jsma.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.ImageEXIF;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class ImageEXIFResponse extends SMResponse {

	@XmlElement(name="Image")
	private ImageEXIF image;
	
	public ImageEXIFResponse() {
	}
	
	public ImageEXIFResponse(String stat, String method, ImageEXIF image) {
		super(stat, method);
		this.image = image;
	}

	public ImageEXIF getImage() {
		return image;
	}

	public void setImage(ImageEXIF image) {
		this.image = image;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((image == null) ? 0 : image.hashCode());
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
		ImageEXIFResponse other = (ImageEXIFResponse) obj;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ImageEXIFResponse ["+toStringSuper()+", image=" + image + "]";
	}
}
