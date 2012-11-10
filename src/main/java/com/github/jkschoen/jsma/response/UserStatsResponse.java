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
	
	public UserStats getUserStats() {
		return userStats;
	}

	public void setUserStats(UserStats userStats) {
		this.userStats = userStats;
	}

	@Override
	public String toString() {
		return "UserStatsResponse ["+toStringSuper()+", userStats=" + userStats + "]";
	}
}
