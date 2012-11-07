package com.github.jkschoen.jsma;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jkschoen.jsma.misc.SmugMugException;
import com.github.jkschoen.jsma.model.Album;
import com.github.jkschoen.jsma.model.Coupon;
import com.github.jkschoen.jsma.response.CouponResponse;
import com.github.jkschoen.jsma.response.CouponsResponse;
import com.github.jkschoen.jsma.response.SMResponse;

public class CouponsAPI extends BaseAPI{
	static final Logger logger = LoggerFactory.getLogger(CommunitiesAPI.class);
	
	private SmugMugAPI smugmug;
	
	protected CouponsAPI(SmugMugAPI smugmug){
		this.smugmug = smugmug;
	}
	
	/**
	 * Create a coupon.
	 * 
	 * <ul>
	 *   <li>AlbumIDs</li>
	 *   <li>Code (required)</li>
	 *   <li>Description</li>
	 *   <li>Discount</li>
	 *   <li>International</li>
	 *   <li>MaxDiscount</li>
	 *   <li>MaxUses</li>
	 *   <li>MinPurchase</li>
	 *   <li>Shipping</li>
	 *   <li>Title (required)</li>
	 *   <li>Type (required)</li>
	 *   <li>ValidFrom</li>
	 *   <li>ValidTo</li>
	 * </ul>
	 * 
	 * @param coupon the coupon to be created
	 * @param extras String array of additional attributes to return in the response
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public Coupon create(Coupon coupon, String[] extras, boolean pretty, boolean strict) throws SmugMugException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		logger.debug("create() called");
		
		Map<String, String> params = new HashMap<String, String>();
		if (coupon.getRestrictions() != null 
				&& coupon.getRestrictions().getAlbums() != null){
			String albumIds = "";
			for (Album album : coupon.getRestrictions().getAlbums()){
				if(albumIds.length() > 0){
					albumIds = albumIds+",";
				}
				albumIds = albumIds+album.getId();
			}
			params.put("AlbumIDs", albumIds);
		}
		if (coupon.getCode() != null){
			params.put("Code", coupon.getCode());
		}
		if (coupon.getDescription() != null){
			params.put("Description", coupon.getDescription());
		}
		if (coupon.getDiscount() != null){
			params.put("Discount", Float.toString(coupon.getDiscount()));
		}
		if (coupon.getInternational() != null){
			params.put("International", Boolean.toString(coupon.getInternational()));
		}
		if (coupon.getMaxDiscount() != null){
			params.put("MaxDiscount", Float.toString(coupon.getMaxDiscount()));
		}
		if (coupon.getMaxDiscount() != null){
			params.put("MaxUses", Float.toString(coupon.getMaxUses()));
		}
		if (coupon.getMinPurchase() != null){
			params.put("MinPurchase", Float.toString(coupon.getMinPurchase()));
		}
		if (coupon.getShipping() != null){
			params.put("Shipping", Boolean.toString(coupon.getShipping()));
		}
		if (coupon.getTitle() != null){
			params.put("Title", coupon.getTitle());
		}
		if (coupon.getType() != null){
			params.put("Type", coupon.getType());
		}
		if (coupon.getValidFrom() != null){
			params.put("ValidFrom", coupon.getValidFrom());
		}
		if (coupon.getValidTo() != null){
			params.put("ValidTo", coupon.getValidTo());
		}
		
		CouponResponse requestToken = SMResponse.callMethod(this.smugmug,CouponResponse.class, "smugmug.coupons.create", params, extras, pretty, false, strict, false);
		logger.debug("create() result: "+(requestToken == null ? "null" : requestToken.toString()));
		coupon.setId(requestToken.getCoupon().getId());
		if (extras != null){
			this.setExtras(coupon, requestToken.getCoupon(), extras);
		}
		return coupon;
	}
	
	/**
	 * Retrieve a list of coupons.
	 * 
	 * @param statuses string array of status values to filter results
	 * @param types string array of type values to filter results
	 * @param extras String array of additional attributes to return in the response
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @param heavy Returns a heavy response for this method.
	 * @return
	 * @throws SmugMugException
	 */
	public List<Coupon> get(String[] statuses, String[] types, String[] extras, boolean pretty, boolean strict, boolean heavy) throws SmugMugException{
		logger.debug("get() called");
		
		Map<String, String> params = new HashMap<String, String>();
		if(statuses != null){
			params.put("Status", this.convertToString(statuses));
		}
		if(types != null){
			params.put("Type", this.convertToString(types));
		}
		
		CouponsResponse requestToken = SMResponse.callMethod(this.smugmug,CouponsResponse.class, "smugmug.albums.get", params, extras, pretty, false, strict, heavy);
		logger.debug("get() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getCoupons();
	}
	
	/**
	 * Retrieve information for a coupon.
	 * 
	 * @param couponId The id for a specific coupon.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public Coupon getInfo(int couponId, boolean pretty, boolean strict) throws SmugMugException{
		logger.debug("getInfo() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("CouponID", Integer.toString(couponId));
		
		CouponResponse requestToken = SMResponse.callMethod(this.smugmug,CouponResponse.class, "smugmug.coupons.getInfo", params, null, pretty, false, strict, false);
		logger.debug("getInfo() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getCoupon();
	}	
	
	/**
	 * Modify an existing coupon.
	 * 
	 * The following fields can be modified:
	 * <ul>
	 *   <li>AlbumIDs</li>
	 *   <li>CouponID (required)</li>
	 *   <li>Code (required)</li>
	 *   <li>Description</li>
	 *   <li>Discount</li>
	 *   <li>International</li>
	 *   <li>MaxDiscount</li>
	 *   <li>MaxUses</li>
	 *   <li>MinPurchase</li>
	 *   <li>Shipping</li>
	 *   <li>Title (required)</li>
	 *   <li>Type (required)</li>
	 *   <li>ValidFrom</li>
	 *   <li>ValidTo</li>
	 * </ul>
	 * 
	 * @param coupon the details to be set on the coupon
	 * @param enabled Toggle the enable/disable state of the coupon
	 * @param extras String array of additional attributes to return in the response
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public Coupon modify(Coupon coupon, Boolean enabled, String[] extras, boolean pretty, boolean strict) throws SmugMugException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		logger.debug("modify() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("CouponID", coupon.getId().toString());

		if (enabled != null){
			params.put("Enabled", enabled.toString());
		}
		if (coupon.getRestrictions() != null 
				&& coupon.getRestrictions().getAlbums() != null){
			String albumIds = "";
			for (Album album : coupon.getRestrictions().getAlbums()){
				if(albumIds.length() > 0){
					albumIds = albumIds+",";
				}
				albumIds = albumIds+album.getId();
			}
			params.put("AlbumIDs", albumIds);
		}
		if (coupon.getCode() != null){
			params.put("Code", coupon.getCode());
		}
		if (coupon.getDescription() != null){
			params.put("Description", coupon.getDescription());
		}
		if (coupon.getDiscount() != null){
			params.put("Discount", Float.toString(coupon.getDiscount()));
		}
		if (coupon.getInternational() != null){
			params.put("International", Boolean.toString(coupon.getInternational()));
		}
		if (coupon.getMaxDiscount() != null){
			params.put("MaxDiscount", Float.toString(coupon.getMaxDiscount()));
		}
		if (coupon.getMaxDiscount() != null){
			params.put("MaxUses", Float.toString(coupon.getMaxUses()));
		}
		if (coupon.getMinPurchase() != null){
			params.put("MinPurchase", Float.toString(coupon.getMinPurchase()));
		}
		if (coupon.getShipping() != null){
			params.put("Shipping", Boolean.toString(coupon.getShipping()));
		}
		if (coupon.getTitle() != null){
			params.put("Title", coupon.getTitle());
		}
		if (coupon.getType() != null){
			params.put("Type", coupon.getType());
		}
		if (coupon.getValidFrom() != null){
			params.put("ValidFrom", coupon.getValidFrom());
		}
		if (coupon.getValidTo() != null){
			params.put("ValidTo", coupon.getValidTo());
		}
		
		CouponResponse requestToken = SMResponse.callMethod(this.smugmug,CouponResponse.class, "smugmug.coupons.modify", params, extras, pretty, false, strict, false);
		logger.debug("modify() result: "+(requestToken == null ? "null" : requestToken.toString()));
		coupon.setId(requestToken.getCoupon().getId());
		if (extras != null){
			this.setExtras(coupon, requestToken.getCoupon(), extras);
		}
		return coupon;
	}

	/**
	 * Add an album restriction to a coupon.
	 * 
	 * @param couponId The id for a specific coupon.
	 * @param albumId The id for a specific album.
	 * @param extras String array of additional attributes to return in the response
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public Coupon restrictionsAlbumAdd(int couponId, int albumId, String[] extras, boolean pretty, boolean strict) throws SmugMugException{
		logger.debug("restrictionsAlbumAdd() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("CouponID", Integer.toString(couponId));
		params.put("AlbumID", Integer.toString(albumId));
		
		CouponResponse requestToken = SMResponse.callMethod(this.smugmug,CouponResponse.class, "smugmug.coupons.restrictions.albums.add", params, extras, pretty, false, strict, false);
		logger.debug("restrictionsAlbumAdd() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getCoupon();
	}
	
	/**
	 * Remove an album restriction to a coupon.
	 * 
	 * @param couponId The id for a specific coupon.
	 * @param albumId The id for a specific album.
	 * @param extras String array of additional attributes to return in the response
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public Coupon restrictionsAlbumRemove(int couponId, int albumId, String[] extras, boolean pretty, boolean strict) throws SmugMugException{
		logger.debug("restrictionsAlbumRemove() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("CouponID", Integer.toString(couponId));
		params.put("AlbumID", Integer.toString(albumId));
		
		CouponResponse requestToken = SMResponse.callMethod(this.smugmug,CouponResponse.class, "smugmug.coupons.restrictions.albums.remove", params, extras, pretty, false, strict, false);
		logger.debug("restrictionsAlbumRemove() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getCoupon();
	}

}
