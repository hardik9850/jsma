package com.github.jkschoen.jsma.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.Image;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ImageResponse extends SMResponse {
	
	@XmlElement(name="Album")
	private Image image;

	public ImageResponse() {
	}
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "ImageResponse ["+toStringSuper()+", image=" + image + "]";
	}
}