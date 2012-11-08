package com.github.jkschoen.jsma;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jkschoen.jsma.misc.SmugMugException;
import com.github.jkschoen.jsma.model.Fan;
import com.github.jkschoen.jsma.response.FansResponse;
import com.github.jkschoen.jsma.response.SMResponse;

public class FansAPI {
	static final Logger logger = LoggerFactory.getLogger(FansAPI.class);

	private SmugMugAPI smugmug;

	protected FansAPI(SmugMugAPI smugmug) {
		this.smugmug = smugmug;
	}

	/**
	 * Retrieve a list of family for a user.
	 * 
	 * @param extras array of extra fields to be populated.
	 * @param pretty return formatted JSON that is easier to read
	 * @param sandboxed Forces URLs to a location with a crossdomain.xml file.
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public List<Fan> get(String[] extras, boolean pretty, boolean sandboxed, boolean strict) throws SmugMugException{
		logger.debug("get() called");
		FansResponse requestToken = SMResponse.callMethod(this.smugmug,FansResponse.class, "smugmug.fans.get", null, extras, pretty, sandboxed, strict, false);
		logger.debug("get() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getFans();
	}
}
