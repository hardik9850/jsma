package com.github.jkschoen.jsma.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.Auth;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RequestToken extends SMResponse {
	
	@XmlElement(name="Auth")
	private Auth auth;

	public RequestToken() {
	}
	
	public Auth getAuth() {
		return auth;
	}

	public void setAuth(Auth auth) {
		this.auth = auth;
	}

	@Override
	public String toString() {
		return "RequestToken ["+toStringSuper()+", auth=" + auth + "]";
	}
}