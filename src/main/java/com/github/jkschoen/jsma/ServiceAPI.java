package com.github.jkschoen.jsma;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jkschoen.jsma.misc.SmugMugException;
import com.github.jkschoen.jsma.response.SMResponse;

public class ServiceAPI {
	static final Logger logger = LoggerFactory.getLogger(ServiceAPI.class);

	private SmugMugAPI smugmug;

	protected ServiceAPI(SmugMugAPI smugmug) {
		this.smugmug = smugmug;
	}
	
	/**
	 * Pings SmugMug.
	 * 
	 * @param pretty return formatted JSON that is easier to read
	 * @return
	 * @throws SmugMugException
	 */
	public boolean ping(boolean pretty) throws SmugMugException{
		logger.debug("ping() called");
		SMResponse requestToken = SMResponse.callMethod(this.smugmug,SMResponse.class, "smugmug.service.ping", null, null, pretty, false, false, false);
		logger.debug("ping() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return true;
	}

}
