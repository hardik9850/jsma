package com.github.jkschoen.jsma;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jkschoen.jsma.misc.SmugMugException;
import com.github.jkschoen.jsma.model.Category;
import com.github.jkschoen.jsma.model.User;
import com.github.jkschoen.jsma.model.UserStats;
import com.github.jkschoen.jsma.response.CategoriesResponse;
import com.github.jkschoen.jsma.response.SMResponse;
import com.github.jkschoen.jsma.response.UserResponse;
import com.github.jkschoen.jsma.response.UserStatsResponse;

public class UserAPI extends BaseAPI{
	static final Logger logger = LoggerFactory.getLogger(UserAPI.class);

	private SmugMugAPI smugmug;

	protected UserAPI(SmugMugAPI smugmug) {
		this.smugmug = smugmug;
	}

	/**
	 * Retrieve the information for a user.
	 * 
	 * @param nickName The NickName for a specific user.
	 * @param extras array of extra fields to be populated.
	 * @param pretty return formatted JSON that is easier to read
	 * @param sandboxed Forces URLs to a location with a crossdomain.xml file.
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public User getInfo(String nickName, String[] extras, boolean pretty, boolean sandboxed, boolean strict) throws SmugMugException{
		logger.debug("getInfo() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("NickName", nickName);
		
		UserResponse requestToken = SMResponse.callMethod(this.smugmug,UserResponse.class, "smugmug.users.getInfo", params, extras, pretty, sandboxed, strict, false);
		logger.debug("getInfo() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getUser();
	}

	
	/**
	 * Retrieve the statistics for a user.
	 * 
	 * @param month The month to retrieve statistics for.
	 * @param year The year to retrieve statistics for.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @param heavy Returns a heavy response for this method.
	 * @return
	 * @throws SmugMugException
	 */
	public UserStats getStats(int month, int year, boolean pretty, boolean strict, boolean heavy) throws SmugMugException {
		logger.debug("getStats() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("Month", Integer.toString(month));
		params.put("Year", Integer.toString(year));
		
		UserStatsResponse requestToken = SMResponse.callMethod(this.smugmug,UserStatsResponse.class, "smugmug.users.getStats", params, null, pretty, false, strict, heavy);
		logger.debug("getStats() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getUserStats();
	}
	
	/**
	 * Retrieve a hierarchical album tree for a user.
	 * 
	 * @param nickName The NickName for a specific user.
	 * @param empty Return empty albums, categories and subcategories.
	 * @param lastUpdated Return results where LastUpdated is after the epoch time provided.
	 * @param sitePassword The site password for a specific user.
	 * @param shareGroupTag The tag (public id) for the sharegroup.
	 * @param extras array of extra fields to be populated.
	 * @param pretty return formatted JSON that is easier to read
	 * @param sandboxed Forces URLs to a location with a crossdomain.xml file.
	 * @param strict Enable strict error handling.
	 * @param heavy Returns a heavy response for this method.
	 * @return
	 * @throws SmugMugException
	 */
	public List<Category> getTree(String nickName, boolean empty, Date lastUpdated, String sitePassword, String shareGroupTag, String[] extras, boolean pretty, boolean sandboxed, boolean strict, boolean heavy) throws SmugMugException{
		logger.debug("getTree() called");
		
		Map<String, String> params = new HashMap<String, String>();
		if(nickName != null){
			params.put("NickName", nickName);
		}
		if(!empty){
			params.put("Empty", "false");
		}
		if(lastUpdated != null){
			params.put("NickName", Long.toString(lastUpdated.getTime()));
		}
		if(sitePassword != null){
			params.put("SitePassword", sitePassword);
		}
		if(shareGroupTag != null){
			params.put("ShareGroupTag", shareGroupTag);
		}
		
		CategoriesResponse requestToken = SMResponse.callMethod(this.smugmug,CategoriesResponse.class, "smugmug.users.getTree", params, null, pretty, sandboxed, strict, heavy);
		logger.debug("getTree() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getCategories();
	}
}
