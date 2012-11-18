package com.github.jkschoen.jsma.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.github.jkschoen.jsma.model.Sharegroup;

public class SharegroupsResponse extends SMResponse {
	
	@XmlElement(name="ShareGroups")
	private List<Sharegroup> sharegroups;

	public SharegroupsResponse() {
	}
	
	public SharegroupsResponse(String stat, String method, List<Sharegroup> sharegroups) {
		super(stat, method);
		this.sharegroups = sharegroups;
	}

	public List<Sharegroup> getSharegroups() {
		return sharegroups;
	}

	public void setSharegroups(List<Sharegroup> sharegroups) {
		this.sharegroups = sharegroups;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((sharegroups == null) ? 0 : sharegroups.hashCode());
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
		SharegroupsResponse other = (SharegroupsResponse) obj;
		if (sharegroups == null) {
			if (other.sharegroups != null)
				return false;
		} else if (!sharegroups.equals(other.sharegroups))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SharegroupsResponse ["+toStringSuper()+", sharegroups=" + sharegroups + "]";
	}
}
