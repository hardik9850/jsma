package com.github.jkschoen.jsma.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.UserStats;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class UserStatsResponse extends SMResponse {
	
	@XmlElement(name="User")
	private UserStats userStats;

	public UserStatsResponse() {
	}
	
	public UserStatsResponse(String stat, String method, UserStats userStats) {
		super(stat, method);
		this.userStats = userStats;
	}

	public UserStats getUserStats() {
		return userStats;
	}

	public void setUserStats(UserStats userStats) {
		this.userStats = userStats;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((userStats == null) ? 0 : userStats.hashCode());
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
		UserStatsResponse other = (UserStatsResponse) obj;
		if (userStats == null) {
			if (other.userStats != null)
				return false;
		} else if (!userStats.equals(other.userStats))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserStatsResponse ["+toStringSuper()+", userStats=" + userStats + "]";
	}
}
