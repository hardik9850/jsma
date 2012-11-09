package com.github.jkschoen.jsma.response;

import javax.xml.bind.annotation.XmlElement;

import com.github.jkschoen.jsma.model.Sharegroup;

public class SharegroupResponse extends SMResponse {
	
	@XmlElement(name="ShareGroup")
	private Sharegroup sharegroup;

	public SharegroupResponse() {
	}
	
	public Sharegroup getSharegroup() {
		return sharegroup;
	}

	public void setSharegroup(Sharegroup sharegroup) {
		this.sharegroup = sharegroup;
	}

	@Override
	public String toString() {
		return "SharegroupResponse ["+toStringSuper()+", sharegroup=" + sharegroup + "]";
	}

}
