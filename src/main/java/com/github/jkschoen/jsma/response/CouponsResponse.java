package com.github.jkschoen.jsma.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.Coupon;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class CouponsResponse extends SMResponse {
	
	@XmlElement(name="Coupons")
	private List<Coupon> coupons;

	public CouponsResponse() {
	}
	
	public List<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}

	@Override
	public String toString() {
		return "CouponsResponse ["+toStringSuper()+", coupons=" + coupons + "]";
	}
}
