package com.github.jkschoen.jsma;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jkschoen.jsma.misc.SmugMugException;
import com.github.jkschoen.jsma.model.Watermark;
import com.github.jkschoen.jsma.response.SMResponse;
import com.github.jkschoen.jsma.response.WatermarkResponse;
import com.github.jkschoen.jsma.response.WatermarksResponse;

public class WatermarkAPI extends BaseAPI{
	static final Logger logger = LoggerFactory.getLogger(WatermarkAPI.class);

	private SmugMugAPI smugmug;

	protected WatermarkAPI(SmugMugAPI smugmug) {
		this.smugmug = smugmug;
	}
	
	/**
	 * Change the settings of a watermark.
	 * 
	 * Changable settings:
	 * <ul>
	 *   <li>WatermarkID (required)</li>
	 *   <li>Dissolve</li>
	 *   <li>ImageID</li>
	 *   <li>Name</li>
	 *   <li>Pinned</li>
	 *   <li>Thumbs</li>
	 * </ul>
	 * 
	 * @param watermark the watermark settings
	 * @param extras array of extra fields to be populated.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public Watermark changeSettings(Watermark watermark, String[] extras, boolean pretty, boolean strict) throws SmugMugException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		logger.debug("changeSettings() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("WatermarkID", watermark.getId().toString());
		if(watermark.getDissolve() != null){
			params.put("Dissolve", watermark.getDissolve().toString());
		}
		if(watermark.getImage() != null && watermark.getImage().getId() != null){
			params.put("ImageID", watermark.getImage().getId().toString());
		}
		if(watermark.getName() != null){
			params.put("Name", watermark.getName());
		}
		if(watermark.getPinned() != null){
			params.put("Pinned", watermark.getPinned());
		}
		if(watermark.getThumbs() != null){
			params.put("Thumbs", watermark.getThumbs() ? "true" : "false");
		}		
		
		WatermarkResponse requestToken = SMResponse.callMethod(this.smugmug,WatermarkResponse.class, "smugmug.watermarks.getInfo", params, extras, pretty, false, strict, false);
		logger.debug("changeSettings() result: "+(requestToken == null ? "null" : requestToken.toString()));
		this.setExtras(watermark, requestToken.getWatermark(), extras);
		return watermark;
	}
	
	/**
	 * 
	 * Create a watermark.
	 * 
	 * Changable settings:
	 * <ul>
	 *   <li>Dissolve</li>
	 *   <li>ImageID</li>
	 *   <li>Name</li>
	 *   <li>Pinned</li>
	 *   <li>Thumbs</li>
	 * </ul>
	 * 
	 * @param watermark the watermark settings
	 * @param extras array of extra fields to be populated.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public Watermark create(Watermark watermark, String[] extras, boolean pretty, boolean strict) throws SmugMugException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		logger.debug("create() called");
		
		Map<String, String> params = new HashMap<String, String>();
		if(watermark.getDissolve() != null){
			params.put("Dissolve", watermark.getDissolve().toString());
		}
		if(watermark.getImage() != null && watermark.getImage().getId() != null){
			params.put("ImageID", watermark.getImage().getId().toString());
		}
		if(watermark.getName() != null){
			params.put("Name", watermark.getName());
		}
		if(watermark.getPinned() != null){
			params.put("Pinned", watermark.getPinned());
		}
		if(watermark.getThumbs() != null){
			params.put("Thumbs", watermark.getThumbs() ? "true" : "false");
		}		
		
		WatermarkResponse requestToken = SMResponse.callMethod(this.smugmug,WatermarkResponse.class, "smugmug.watermarks.create", params, extras, pretty, false, strict, false);
		logger.debug("create() result: "+(requestToken == null ? "null" : requestToken.toString()));
		this.setExtras(watermark, requestToken.getWatermark(), extras);
		return watermark;
	}

	/**
	 * Delete a watermark.
	 * 
	 * @param WatermarkID (required) The id for a specific watermark.
	 * @param albumId The id for a specific album.
	 * @param pretty Return a more human friendly response.
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public boolean delete(long watermarkId, Integer albumId, boolean pretty, boolean strict) throws SmugMugException {
		logger.debug("delete() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("WatermarkID" , Long.toString(watermarkId));
		
		SMResponse requestToken = SMResponse.callMethod(this.smugmug,SMResponse.class, "smugmug.watermarks.delete", params, null, pretty, false, strict, false);
		logger.debug("delete() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return true;
	}
	
	/**
	 * Retrieve a list of watermarks.
	 * 
	 * @param extras array of extra fields to be populated.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @param heavy Returns a heavy response for this method.
	 * @return
	 * @throws SmugMugException
	 */
	public List<Watermark> get(String[] extras, boolean pretty, boolean strict, boolean heavy) throws SmugMugException{
		logger.debug("get() called");
		
		WatermarksResponse requestToken = SMResponse.callMethod(this.smugmug,WatermarksResponse.class, "smugmug.watermarks.get", null, extras, pretty, false, strict, heavy);
		logger.debug("get() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getWatermarks();
	}
	
	/**
	 * Retrieve the information for a watermark.
	 * 
	 * @param warmarkId the id for a specific watermark.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public Watermark getInfo(long warmarkId, boolean pretty, boolean strict) throws SmugMugException{
		logger.debug("getInfo() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("WatermarkID", Long.toString(warmarkId));
		WatermarkResponse requestToken = SMResponse.callMethod(this.smugmug,WatermarkResponse.class, "smugmug.watermarks.getInfo", params, null, pretty, false, strict, false);
		logger.debug("getInfo() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getWatermark();
	}
	
}
