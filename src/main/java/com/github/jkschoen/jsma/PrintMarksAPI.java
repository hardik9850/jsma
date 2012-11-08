package com.github.jkschoen.jsma;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jkschoen.jsma.misc.SmugMugException;
import com.github.jkschoen.jsma.model.Printmark;
import com.github.jkschoen.jsma.response.PrintmarkResponse;
import com.github.jkschoen.jsma.response.PrintmarksResponse;
import com.github.jkschoen.jsma.response.SMResponse;

public class PrintMarksAPI extends BaseAPI{
	static final Logger logger = LoggerFactory.getLogger(PrintMarksAPI.class);

	private SmugMugAPI smugmug;

	protected PrintMarksAPI(SmugMugAPI smugmug) {
		this.smugmug = smugmug;
	}
	
	/**
	 * Create a printmark.
	 * 
	 * The following fields can be set when creating a printmark.
	 * <ul>
	 * 	 <li>Dissolve</li>
	 * 	 <li>ImageID (required)</li>
	 * 	 <li>Location</li>
	 * 	 <li>Name (required)</li>
	 * 	 <li></li>
	 * </ul>
	 * 
	 * @param printmark the new values
	 * @param extras array of extra fields to be populated.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public Printmark create(Printmark printmark, String[] extras, boolean pretty, boolean strict) throws SmugMugException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		logger.debug("create() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("Name", printmark.getName());		
		params.put("ImageID", printmark.getImage().getId().toString());
		if (printmark.getDissolve() != null){
			params.put("Dissolve", printmark.getDissolve().toString());
		}
		if (printmark.getLocation() != null){
			params.put("Location", printmark.getLocation());
		}

		PrintmarkResponse requestToken = SMResponse.callMethod(this.smugmug,PrintmarkResponse.class, "smugmug.printmarks.create", params, extras, pretty, false, strict, false);
		logger.debug("create() result: "+(requestToken == null ? "null" : requestToken.toString()));
		printmark.setId(requestToken.getPrintmark().getId());
		if(extras != null){
			this.setExtras(printmark, requestToken.getPrintmark(), extras);
		}
		return printmark;
	}
	
	/**
	 * Delete a printmark.
	 * 
	 * @param printmarkId The id for a specific printmark.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public boolean delete(int printmarkId, boolean pretty, boolean strict) throws SmugMugException{
		logger.debug("delete() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("PrintmarkID", Integer.toString(printmarkId));
		
		SMResponse requestToken = SMResponse.callMethod(this.smugmug,SMResponse.class, "smugmug.printmarks.delete", params, null, pretty, false, strict, false);
		logger.debug("delete() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return true;
	}
	

	/**
	 * Retrieve a list of printmarks.
	 * 
	 * @param extras array of extra fields to be populated.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @param heavy Returns a heavy response for this method.
	 * @return
	 * @throws SmugMugException
	 */
	public List<Printmark> get(String[] extras, boolean pretty, boolean strict, boolean heavy) throws SmugMugException{
		logger.debug("get() called");
		
		PrintmarksResponse requestToken = SMResponse.callMethod(this.smugmug,PrintmarksResponse.class, "smugmug.printmarks.get", null, extras, pretty, false, strict, heavy);
		logger.debug("get() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getPrintmarks();
	}
	
	/**
	 * Retrieve information for a printmark.
	 * 
	 * @param printmarkId The id for a specific printmark.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public Printmark getInfo(int printmarkId, boolean pretty, boolean strict) throws SmugMugException{
		logger.debug("getInfo() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("PrintmarkID", Integer.toString(printmarkId));
		PrintmarkResponse requestToken = SMResponse.callMethod(this.smugmug,PrintmarkResponse.class, "smugmug.printmarks.getInfo", params, null, pretty, false, strict, false);
		logger.debug("getInfo() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getPrintmark();
	}

	/**
	 * Modify a printmark.
	 * 
	 * The following fields can be set when modifying a printmark.
	 * <ul>
	 * 	 <li>Dissolve</li>
	 * 	 <li>ImageID (required)</li>
	 * 	 <li>Location</li>
	 * 	 <li>Name (required)</li>
	 *   <li>PrintmarkID (required)</li>
	 * 	 <li></li>
	 * </ul>
	 * 
	 * @param printmark the new values
	 * @param extras array of extra fields to be populated.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public Printmark modify(Printmark printmark, String[] extras, boolean pretty, boolean strict) throws SmugMugException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		logger.debug("modify() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("PrintmarkID", printmark.getId().toString());
		if (printmark.getName() != null){
			params.put("Name", printmark.getName());
		}
		if (printmark.getId() != null){
			params.put("ImageID", printmark.getImage().getId().toString());
		}
		if (printmark.getDissolve() != null){
			params.put("Dissolve", printmark.getDissolve().toString());
		}
		if (printmark.getLocation() != null){
			params.put("Location", printmark.getLocation());
		}

		PrintmarkResponse requestToken = SMResponse.callMethod(this.smugmug,PrintmarkResponse.class, "smugmug.printmarks.modify", params, extras, pretty, false, strict, false);
		logger.debug("modify() result: "+(requestToken == null ? "null" : requestToken.toString()));
		printmark.setId(requestToken.getPrintmark().getId());
		if(extras != null){
			this.setExtras(printmark, requestToken.getPrintmark(), extras);
		}
		return printmark;
	}

}
