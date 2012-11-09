package com.github.jkschoen.jsma.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.github.jkschoen.jsma.model.Sharegroup;

public class SharegroupsResponse extends SMResponse {
	
	@XmlElement(name="ShareGroups")
	private List<Sharegroup> sharegroups;

	public SharegroupsResponse() {
	}
	
	public List<Sharegroup> getSharegroups() {
		return sharegroups;
	}

	public void setSharegroups(List<Sharegroup> sharegroups) {
		this.sharegroups = sharegroups;
	}

	@Override
	public String toString() {
		return "SharegroupsResponse ["+toStringSuper()+", sharegroups=" + sharegroups + "]";
	}
}
