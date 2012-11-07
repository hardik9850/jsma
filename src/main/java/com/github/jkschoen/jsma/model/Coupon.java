package com.github.jkschoen.jsma.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Coupon {
	
	@XmlElement(name="id")
	private Integer id;
	
	@XmlElement(name="Amount")
	private Float amount;
	
	@XmlElement(name="Code")
	private String code;
	
	@XmlElement(name="Description")
	private String description;
	
	@XmlElement(name="Discount")
	private Float discount;
	
	@XmlElement(name="International")
	private Boolean international;
	
	@XmlElement(name="MaxDiscount")
	private Float maxDiscount;
	
	@XmlElement(name="MaxUses")
	private Integer maxUses;
	
	@XmlElement(name="MinPurchase")
	private Float minPurchase;
	
	@XmlElement(name="Restrictions")
	private Restrictions restrictions;
	
	@XmlElement(name="Shipping")
	private Boolean shipping;
	
	@XmlElement(name="Status")
	private String status;
	
	@XmlElement(name="Title")
	private String title;
	
	@XmlElement(name="Type")
	private String type;
	
	@XmlElement(name="Uses")
	private Integer uses;
	
	@XmlElement(name="ValidFrom")
	private String validFrom;
	
	@XmlElement(name="ValidTo")
	private String validTo;

	public Coupon() {
	}

	/**
	 * The id for this coupon.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Set the id for this coupon.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * The total amount (in dollars) discounted using this coupon.
	 */
	public Float getAmount() {
		return amount;
	}

	/**
	 * Set the total amount (in dollars) discounted using this coupon.
	 */
	public void setAmount(Float amount) {
		this.amount = amount;
	}

	/**
	 * The code for this coupon.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Set the code for this coupon.
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * The description for this coupon.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description for this coupon.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * The discount (in dollars or percent) for this coupon.
	 * (Amount, Credit & Percent coupons only)
	 */
	public Float getDiscount() {
		return discount;
	}

	/**
	 * Set the discount (in dollars or percent) for this coupon.
	 * (Amount, Credit & Percent coupons only)
	 */
	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	/**
	 * Allow this coupon to cover international shipping costs.
	 * (Shipping coupons only)
	 */
	public Boolean getInternational() {
		return international;
	}

	/**
	 * Sets whether to allow this coupon to cover international shipping costs.
	 * (Shipping coupons only)
	 */
	public void setInternational(Boolean international) {
		this.international = international;
	}

	/**
	 * The maximum discount (in dollars) allowed for this coupon.
	 * (Percent coupons only)
	 */
	public Float getMaxDiscount() {
		return maxDiscount;
	}

	/**
	 * Sets the maximum discount (in dollars) allowed for this coupon.
	 * (Percent coupons only)
	 */
	public void setMaxDiscount(Float maxDiscount) {
		this.maxDiscount = maxDiscount;
	}

	/**
	 * The maximum number of uses allowed for this coupon.
	 * (Amount, Cost, Percent & Shipping coupons only)
	 */
	public Integer getMaxUses() {
		return maxUses;
	}

	/**
	 * Set the maximum number of uses allowed for this coupon.
	 * (Amount, Cost, Percent & Shipping coupons only)
	 */
	public void setMaxUses(Integer maxUses) {
		this.maxUses = maxUses;
	}

	/**
	 * The minimum purchase (in dollars) required for this coupon.
	 * (Amount, Percent & Shipping coupons only)
	 */
	public Float getMinPurchase() {
		return minPurchase;
	}

	/**
	 * Set the minimum purchase (in dollars) required for this coupon.
	 * (Amount, Percent & Shipping coupons only)
	 */
	public void setMinPurchase(Float minPurchase) {
		this.minPurchase = minPurchase;
	}

	/**
	 * Restrictions for this coupon.
	 */
	public Restrictions getRestrictions() {
		return restrictions;
	}

	/**
	 * Sets the restrictions 
	 */
	public void setRestrictions(Restrictions restrictions) {
		this.restrictions = restrictions;
	}

	/**
	 * Allow this coupon to cover shipping costs.
	 * (Amount, Credit & Percent coupons only)
	 */
	public Boolean getShipping() {
		return shipping;
	}

	/**
	 * Sets whether to allow this coupon to cover shipping costs.
	 * (Amount, Credit & Percent coupons only)
	 */
	public void setShipping(Boolean shipping) {
		this.shipping = shipping;
	}

	/**
	 * The status for this coupon.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Set the status for this coupon.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * The title for this coupon.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set the title for this coupon.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * The type of coupon.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set the type of coupon.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * The number of times this coupon has been used.
	 */
	public Integer getUses() {
		return uses;
	}

	/**
	 * Sets the number of times this coupon has been used.
	 */
	public void setUses(Integer uses) {
		this.uses = uses;
	}

	/**
	 * The date this coupon is valid from.
	 */
	public String getValidFrom() {
		return validFrom;
	}

	/**
	 * Set the date this coupon is valid from.
	 */
	public void setValidFrom(String validForm) {
		this.validFrom = validForm;
	}

	/**
	 * The date this coupon is valid to.
	 */
	public String getValidTo() {
		return validTo;
	}

	/**
	 * Set the date this coupon is valid to.
	 */
	public void setValidTo(String validTo) {
		this.validTo = validTo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((international == null) ? 0 : international.hashCode());
		result = prime * result
				+ ((maxDiscount == null) ? 0 : maxDiscount.hashCode());
		result = prime * result + ((maxUses == null) ? 0 : maxUses.hashCode());
		result = prime * result
				+ ((minPurchase == null) ? 0 : minPurchase.hashCode());
		result = prime * result
				+ ((restrictions == null) ? 0 : restrictions.hashCode());
		result = prime * result
				+ ((shipping == null) ? 0 : shipping.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((uses == null) ? 0 : uses.hashCode());
		result = prime * result
				+ ((validFrom == null) ? 0 : validFrom.hashCode());
		result = prime * result + ((validTo == null) ? 0 : validTo.hashCode());
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
		Coupon other = (Coupon) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (discount == null) {
			if (other.discount != null)
				return false;
		} else if (!discount.equals(other.discount))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (international == null) {
			if (other.international != null)
				return false;
		} else if (!international.equals(other.international))
			return false;
		if (maxDiscount == null) {
			if (other.maxDiscount != null)
				return false;
		} else if (!maxDiscount.equals(other.maxDiscount))
			return false;
		if (maxUses == null) {
			if (other.maxUses != null)
				return false;
		} else if (!maxUses.equals(other.maxUses))
			return false;
		if (minPurchase == null) {
			if (other.minPurchase != null)
				return false;
		} else if (!minPurchase.equals(other.minPurchase))
			return false;
		if (restrictions == null) {
			if (other.restrictions != null)
				return false;
		} else if (!restrictions.equals(other.restrictions))
			return false;
		if (shipping == null) {
			if (other.shipping != null)
				return false;
		} else if (!shipping.equals(other.shipping))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (uses == null) {
			if (other.uses != null)
				return false;
		} else if (!uses.equals(other.uses))
			return false;
		if (validFrom == null) {
			if (other.validFrom != null)
				return false;
		} else if (!validFrom.equals(other.validFrom))
			return false;
		if (validTo == null) {
			if (other.validTo != null)
				return false;
		} else if (!validTo.equals(other.validTo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", amount=" + amount + ", code=" + code
				+ ", description=" + description + ", discount=" + discount
				+ ", international=" + international + ", maxDiscount="
				+ maxDiscount + ", maxUses=" + maxUses + ", minPurchase="
				+ minPurchase + ", restrictions=" + restrictions
				+ ", shipping=" + shipping + ", status=" + status + ", title="
				+ title + ", type=" + type + ", uses=" + uses + ", validForm="
				+ validFrom + ", validTo=" + validTo + "]";
	}
	
}
