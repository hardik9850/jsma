package com.github.jkschoen.jsma;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jkschoen.jsma.misc.SmugMugException;
import com.github.jkschoen.jsma.model.Community;
import com.github.jkschoen.jsma.response.CommunitiesResponse;
import com.github.jkschoen.jsma.response.SMResponse;

public class CommunitiesAPI {
	static final Logger logger = LoggerFactory.getLogger(CommunitiesAPI.class);
	
	private SmugMugAPI smugmug;
	
	protected CommunitiesAPI(SmugMugAPI smugmug){
		this.smugmug = smugmug;
	}

	/**
	 * Retrieve a list of communities for a user.
	 * 
	 * @param pretty Return a more human friendly response.
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public List<Community> get(boolean pretty, boolean strict) throws SmugMugException{
		logger.debug("get() called");
		CommunitiesResponse requestToken = SMResponse.callMethod(this.smugmug,CommunitiesResponse.class, "smugmug.categories.create", null, null, pretty, false, strict, false);
		logger.debug("get() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getCommunities();
	}
}
