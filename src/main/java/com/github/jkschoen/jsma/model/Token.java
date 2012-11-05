package com.github.jkschoen.jsma.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Token {

	@XmlElement(name="id")
	private String id;
	
	@XmlElement(name="Secret")
	private String secret;
	
	@XmlElement(name="Access")
	private String access;
	
	@XmlElement(name="Permissions")
	private String permissions;

	public Token() {
	}

	public Token(String id, String secret) {
		this.id = id;
		this.secret = secret;
	}

	/**
	 * The OAuth token.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the OAuth token.
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * The OAuth token secret.
	 */
	public String getSecret() {
		return secret;
	}

	/**
	 * Sets the OAuth token secret.
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}

	/**
	 * The access level for this OAuth access token.
	 */
	public String getAccess() {
		return access;
	}

	/**
	 * Sets the access level for this OAuth access token.
	 */
	public void setAccess(String access) {
		this.access = access;
	}

	/**
	 * The permissions for this OAuth access token.
	 */
	public String getPermissions() {
		return permissions;
	}

	/**
	 * Sets the permissions for this OAuth access token.
	 */
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((access == null) ? 0 : access.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((permissions == null) ? 0 : permissions.hashCode());
		result = prime * result + ((secret == null) ? 0 : secret.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Token other = (Token) obj;
		if (access == null) {
			if (other.access != null)
				return false;
		} else if (!access.equals(other.access))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (permissions == null) {
			if (other.permissions != null)
				return false;
		} else if (!permissions.equals(other.permissions))
			return false;
		if (secret == null) {
			if (other.secret != null)
				return false;
		} else if (!secret.equals(other.secret))
			return false;
		return true;
	}

	@Override
    public String toString() {
        return " id="+id+" secret="+secret+" access="+access+" permissions="+permissions;
    }
	
}
