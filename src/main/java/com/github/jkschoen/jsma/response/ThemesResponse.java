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
	
	public ThemesResponse(String stat, String method, List<Theme> themes) {
		super(stat, method);
		this.themes = themes;
	}

	public List<Theme> getThemes() {
		return themes;
	}

	public void setThemes(List<Theme> albums) {
		this.themes = albums;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((themes == null) ? 0 : themes.hashCode());
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
		ThemesResponse other = (ThemesResponse) obj;
		if (themes == null) {
			if (other.themes != null)
				return false;
		} else if (!themes.equals(other.themes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ThemesResponse ["+toStringSuper()+", themes=" + themes + "]";
	}
}
