package com.github.jkschoen.jsma.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
	
	@XmlElement(name="id")
	private Integer id;
	
	@XmlElement(name="AccountStatus")
	private  String accountStatus;
	
	@XmlElement(name="AccountType")
	private String accountType;
	
	@XmlElement(name="FileSizeLimit") 
	private Integer fileSizeLimit;
	
	@XmlElement(name="Name")
	private String name;
	
	@XmlElement(name="NickName")
	private String nickName;
	
	@XmlElement(name="SmugVault") 
	private Boolean smugVault;
	
	@XmlElement(name="URL")
	private String url;
	
	public User() {
	}

	/**
	 * The id for this user.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id for this user.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * The account status for this user.
	 */
	public String getAccountStatus() {
		return accountStatus;
	}

	/**
	 * Sets the account status for this user.
	 */
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	 
	/**
	 * The account type for this user.
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * Sets the account type for this user.
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	/**
	 * The file size limit for this user's account.
	 */
	public Integer getFileSizeLimit() {
		return fileSizeLimit;
	}

	/**
	 * Sets the file size limit for this user's account.
	 */
	public void setFileSizeLimit(Integer fileSizeLimit) {
		this.fileSizeLimit = fileSizeLimit;
	}

	/**
	 * The Name for this user.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the Name for this user.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * The NickName for this user.
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * Sets the NickName for this user.
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	/**
	 * SmugVault is enabled for this user's account.
	 */
	public Boolean getSmugVault() {
		return smugVault;
	}

	/**
	 * Sets whether SmugVault is enabled for this user's account.
	 */
	public void setSmugVault(Boolean smugVault) {
		this.smugVault = smugVault;
	}
	
	/**
	 * The homepage URL for this user.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the homepage URL for this user.
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountStatus == null) ? 0 : accountStatus.hashCode());
		result = prime * result
				+ ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result
				+ ((fileSizeLimit == null) ? 0 : fileSizeLimit.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result
				+ ((smugVault == null) ? 0 : smugVault.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		User other = (User) obj;
		if (accountStatus == null) {
			if (other.accountStatus != null)
				return false;
		} else if (!accountStatus.equals(other.accountStatus))
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (fileSizeLimit == null) {
			if (other.fileSizeLimit != null)
				return false;
		} else if (!fileSizeLimit.equals(other.fileSizeLimit))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		if (smugVault == null) {
			if (other.smugVault != null)
				return false;
		} else if (!smugVault.equals(other.smugVault))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
    public String toString() {
        return " id="+id+
        		" accountStatus="+accountStatus+
        		" accountType="+accountType+
        		" fileSizeLimit="+fileSizeLimit+
        		" name="+name+
        		" nickName="+nickName+
        		" smugVault="+smugVault+
        		" url="+url;
    }

}
