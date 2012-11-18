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
	
	public CouponsResponse(String stat, String method, List<Coupon> coupons) {
		super(stat, method);
		this.coupons = coupons;
	}

	public List<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((coupons == null) ? 0 : coupons.hashCode());
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
		CouponsResponse other = (CouponsResponse) obj;
		if (coupons == null) {
			if (other.coupons != null)
				return false;
		} else if (!coupons.equals(other.coupons))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CouponsResponse ["+toStringSuper()+", coupons=" + coupons + "]";
	}
}
