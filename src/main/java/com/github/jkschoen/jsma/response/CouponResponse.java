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
	
	public CouponResponse(String stat, String method, Coupon coupon) {
		super(stat, method);
		this.coupon = coupon;
	}
	
	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((coupon == null) ? 0 : coupon.hashCode());
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
		CouponResponse other = (CouponResponse) obj;
		if (coupon == null) {
			if (other.coupon != null)
				return false;
		} else if (!coupon.equals(other.coupon))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CouponResponse ["+toStringSuper()+", coupon=" + coupon + "]";
	}
}
