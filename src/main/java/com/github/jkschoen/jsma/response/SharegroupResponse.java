package com.github.jkschoen.jsma.response;

import javax.xml.bind.annotation.XmlElement;

import com.github.jkschoen.jsma.model.Sharegroup;

public class SharegroupResponse extends SMResponse {
	
	@XmlElement(name="ShareGroup")
	private Sharegroup sharegroup;

	public SharegroupResponse() {
	}
	
	public SharegroupResponse(String stat, String method, Sharegroup sharegroup) {
		super(stat, method);
		this.sharegroup = sharegroup;
	}

	public Sharegroup getSharegroup() {
		return sharegroup;
	}

	public void setSharegroup(Sharegroup sharegroup) {
		this.sharegroup = sharegroup;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((sharegroup == null) ? 0 : sharegroup.hashCode());
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
		SharegroupResponse other = (SharegroupResponse) obj;
		if (sharegroup == null) {
			if (other.sharegroup != null)
				return false;
		} else if (!sharegroup.equals(other.sharegroup))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SharegroupResponse ["+toStringSuper()+", sharegroup=" + sharegroup + "]";
	}

}
