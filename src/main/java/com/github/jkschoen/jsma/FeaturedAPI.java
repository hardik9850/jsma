package com.github.jkschoen.jsma;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jkschoen.jsma.misc.SmugMugException;
import com.github.jkschoen.jsma.model.Featured;
import com.github.jkschoen.jsma.response.FeaturedResponse;
import com.github.jkschoen.jsma.response.SMResponse;

public class FeaturedAPI {
	static final Logger logger = LoggerFactory.getLogger(FeaturedAPI.class);

	private SmugMugAPI smugmug;

	protected FeaturedAPI(SmugMugAPI smugmug) {
		this.smugmug = smugmug;
	}
	
	/**
	 * Retrieve a list of featured albums for a given user.
	 * 
	 * @param nickName The NickName for a specific user.
	 * @param sitePassword The site password for a specific user.
	 * @param extras array of extra fields to be populated.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @param heavy Returns a heavy response for this method.
	 * @return
	 * @throws SmugMugException
	 */
	public Featured get(String nickName, String sitePassword, String[] extras, boolean pretty, boolean strict, boolean heavy) throws SmugMugException{
		logger.debug("get() called");
		Map<String, String> params = new HashMap<String, String>();
		if(nickName != null){
			params.put("NickName", nickName);
		}
		if(sitePassword != null){
			params.put("SitePassword", sitePassword);
		}
		FeaturedResponse requestToken = SMResponse.callMethod(this.smugmug,FeaturedResponse.class, "smugmug.featured.albums.get", params, extras, pretty, false, strict, heavy);
		logger.debug("get() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getFeatured();
	}
}
