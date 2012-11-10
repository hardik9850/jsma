package com.github.jkschoen.jsma.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.jkschoen.jsma.model.Coupon;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class CouponResponse extends SMResponse {
	
	@XmlElement(name="Coupon")
	private Coupon coupon;

	public CouponResponse() {
	}
	
	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	@Override
	public String toString() {
		return "CouponResponse ["+toStringSuper()+", coupon=" + coupon + "]";
	}
}
