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
	
	public ImageEXIF getImage() {
		return image;
	}

	public void setImage(ImageEXIF image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "ImageEXIFResponse ["+toStringSuper()+", image=" + image + "]";
	}
}
