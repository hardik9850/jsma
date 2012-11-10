package com.github.jkschoen.jsma.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.Theme;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class ThemesResponse extends SMResponse {

	@XmlElement(name="Themes")
	private List<Theme> themes;

	public ThemesResponse() {
	}
	
	public List<Theme> getThemes() {
		return themes;
	}

	public void setThemes(List<Theme> albums) {
		this.themes = albums;
	}

	@Override
	public String toString() {
		return "ThemesResponse ["+toStringSuper()+", themes=" + themes + "]";
	}
}
